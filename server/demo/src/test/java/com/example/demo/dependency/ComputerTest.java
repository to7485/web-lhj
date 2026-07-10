package com.example.demo.dependency;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest// 스프링부트 프로젝트 테스트에 필요한 모든 의존성을 제공한다.
@Slf4j
public class ComputerTest {
	
	//필드 주입
	//AppContext에 저장되어 있는 객체가 coding변수에 들어감
	@Autowired
	Coding coding;

	//computerTest()메서드가 실행이 될 때 coding객체에는
	//컨테이너가 저장하고 있는 객체가 주입이 된다.
	@Test
	public void computerTest(){
		//coding = new Coding(); X
		log.info(coding.getComputer().toString());
	}
}









