package com.korea.todo.security;

import java.io.IOException;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final TokenProvider tokenProvider;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			//HTTP 요청의 Authorization 헤더에서 JWT를 추출한다.
			//보통 클라이언트가 토큰을 다음과 같이 전송한다.
			//Authorization : Bearer 토큰...
			
			String token = parseBearerToken(request);
			
			log.info("JWT Filter is running...");
			
			//토큰이 존재할 때만 JWT 인증을 수행한다.
			if(token !=null && !token.equalsIgnoreCase("null")) {
				
				String userId = tokenProvider.validateAndGetUserId(token);
				
				log.info("Authenticated user ID : {}", userId);
				
				//검증에 성공을 했고
				//스프링 시큐리티가 이해할 수 있는 인증 객체를 만든다.
				//검증이 끝난 사용자를 "인증 완료된 사용자"로 표현하기 위한것
				AbstractAuthenticationToken authentication = 
						new UsernamePasswordAuthenticationToken(
								userId, //사용자 정보
								null, //인증 수단(jwt로 이미 인증했으니 null)
								AuthorityUtils.NO_AUTHORITIES//권한(권한 없음)
								);
				
				//authentication객체에 현재 HTTP요청과 관련된 부가 정보를 저장
				//요청정보에서 클라이언트 IP 주소, 세션 ID를 추가로 저장을 하겠다.
				authentication.setDetails(
						new WebAuthenticationDetailsSource().buildDetails(request));
				
				//비어있는 SecurityContext 객체를 생성
				//현재 요청의 인증 정보를 저장하는 공간
				SecurityContext securityContext = 
						SecurityContextHolder.createEmptyContext();
				
				//이 시점부터 현재 인증된 사용자 정보가 들어간다.
				securityContext.setAuthentication(authentication);
				
				//SecurityContextHolder
				//시큐리티가 현재 인증된 사용자 정보를 조회하기 위해 사용하는 클래스
				//등록이 완료되면 시큐리티는 현재 요청을 "인증된 사용자의 요청"으로 인식할 수 있다.
				SecurityContextHolder.setContext(securityContext);
				
			}
		} catch (Exception e) {
			//인증 과정에서 예외가 발생된 경우 실행
			
			//1. 토큰의 만료
			//2. 잘못된 JWT 형식
			//3. JWT 서명이 불일치
			//4. JWT 변조
			//5. 잘못된 비밀키
			logger.error("Coud not set user authentication in security context", e);
		}
		
		//현재 필터 작업이 끝났으니 요청 처리를 다음 단계로 진행시켜라.
		filterChain.doFilter(request, response);
		
	}
	
	private String parseBearerToken(HttpServletRequest request) {
		//HTTP 요청의 헤더를 파싱해 토큰을 반환한다.
		String bearerToken = request.getHeader("Authorization");
		
		//앞에 붙어있는 "Bearer "를 떼고 토큰값만 반환
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			System.out.println(bearerToken.substring(7));
			return bearerToken.substring(7);
		}
		return null;
	}
	
	
	
	
	
	
	
	
}









