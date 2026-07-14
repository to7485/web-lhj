package com.korea.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	//WebMvcConfigurer : Spring MVC의 기본설정을 변경할 수 있는 인터페이스

	//addCorsMappings() : 스프링부트가 시작될 때 이 메서드를 호출한다
	//registry : CORS 설정을 등록하는 객체
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		registry
			.addMapping("/**")//모든 리소스에 대해 CORS 설정을 적용
			.allowedOrigins("http://127.0.0.1:5500")
			.allowedMethods("GET","POST","PUT","DELETE")//http 요청 메서드 허용
			.allowedHeaders("*")//모든헤더를 허용
			.allowCredentials(true) //쿠키나 인증 정보를 포함한 요청 허용
			.maxAge(3600); //브라우저가 서버로부터 받은 응답을 일정 시간 동안 저장
		
	}
	
	
	
	
	
	
	
}
