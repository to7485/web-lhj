package com.korea.todo.security;

import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity //시큐리티의 웹 보안 기능을 활성화
@RequiredArgsConstructor
public class WebSecurityConfig {
	
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(
			HttpSecurity http,
			TokenProvider tokenProvider) throws Exception{
		
		http
			.cors(cors -> cors.configurationSource(corsConfigurationSource()))
			//csrf : 사용자의 인증 정보를 악용하여 원하지 않는 요청을 보내게 만드는 공격에 대한 보호기능
			.csrf(csrf -> csrf.disable())
			//httpBasic인증 비활성화 우리는 jwt 방식으로 인증하기 때문에 basic인증을 하지 않는다.
			.httpBasic(httpBasic -> httpBasic.disable())
			//세션 관리 방식을 무상태로 설정
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			//URL에 따라 인증없이 접근할 수 있는곳, 인증을 해야 접근할 수 있는 곳
			.authorizeHttpRequests(auth -> auth.requestMatchers("/","/auth/**","/error").permitAll().anyRequest().authenticated())
			//JWT 인증 필터를 시큐리티 필터체인에 추가한다.
			//addFilterBefore(A,B) : A필터를 B필터보다 먼저 실행한다.
			.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
			return http.build();
	}
	
	//서블릿 필터 자동등록 막기
	//JwtAuthenticationFilter가 @Componet이므로 스프링 bean으로 등록이 되어있다.
	//하지만 Fiter 타입의 bean을 컨테이터의 일반 Filter로도 자동등록될 수 있다.
	@Bean
	public FilterRegistrationBean<JwtAuthenticationFilter> jwtAuthenticationFilterRegistration(
		JwtAuthenticationFilter filter){
		FilterRegistrationBean<JwtAuthenticationFilter> registration = 
				new FilterRegistrationBean<>(filter);
		
		//일반 Filter로 자동등록되는 것을 막는다.
		registration.setEnabled(false);
		return registration;
	}
		
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		//CORS 정책을 저장하는 객체 생성
		CorsConfiguration configuration = 
				new CorsConfiguration();
		
		//요청을 허용할 Origin을 설정
		configuration.setAllowedOrigins(List.of("http://localhost:3000"));
		configuration.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
		configuration.setAllowedHeaders(List.of("*"));
		configuration.setAllowCredentials(true);
		
		//URL 경로별로 CORS 설정을 등록하기 위한 객체
		UrlBasedCorsConfigurationSource source = 
				new UrlBasedCorsConfigurationSource();
		
		source.registerCorsConfiguration("/**", configuration);
		
		return source;
	}

}





