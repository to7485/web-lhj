package com.korea.todo.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.korea.todo.entity.UserEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenProvider {

	//해싱 알고리즘 : JWT의 서명을 만들 때 사용하는 알고리즘
	//HS512 : 시크릿키가 최소 512비트(64바이트)이상이어야 한다.
	private static final String SECRET_KEY = "OGPNbU6gWFVTTkiTL2comdY7tzZ86CxT1uUXlOZBamPWF4LlzVHfoG49WA6YKZWhsu8uTokq2dLc9wt0uWK2Bj";
	
	//토큰을 만들어주는 메서드
	public String create(UserEntity userEntity) {
		
		//만료시간 설정
		//Instant.now() : 현재 시간
		//plus(1,ChronoUnit.DAYS) : 현재 시간에서 1일을 더한다.
		//Date.from() : Instant객체를 java.util.Date객체로 변환한다.
		Date expiryDate = Date.from(Instant.now().plus(1,ChronoUnit.DAYS));
		
		//토큰의 구조
		//헤더
		//페이로드
		//서명
		/*
		 * {
		 * 	"alg":"HS512"
		 * }.
		 * {
		 * 	"sub":"....",
		 * 	"iss":"todo app",
		 * 	"iat":1595733657,
		 * 	"exp"...}.
		 * 서명
		 * */
		
		
		
		//JWT 토큰을 생성해서 반환
		return Jwts.builder()
				//header에 들어갈 내용 및 서명을 하기 위한 시크릿키
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY)
				//페이로드에 들어갈 내용
				.setSubject(userEntity.getId())
				.setIssuer("todo app")
				.setIssuedAt(new Date())
				.setExpiration(expiryDate)
				.compact();
	}
	
	//토큰을 디코딩하고 유저의 아이디를 파싱 및 위조여부를 확인
	public String validateAndGetUserId(String token) {
		Claims claims = Jwts.parserBuilder()
				//JWT 서명 검증에 사용할 키
				.setSigningKey(SECRET_KEY)
				//JwT Parser 생성
				.build()
				//JwT 서명 및 유효성 검증
				.parseClaimsJws(token)
				//Payload 추출
				.getBody();
		
		//sub에 저장된 사용자 ID 반환
		return claims.getSubject();
	}
}










