package com.korea.architecture.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ChefRunner implements CommandLineRunner{
	
	//CommandLineRunner
	//스프링부트에서 run()메서드 하나만 가지고 있는 인터페이스
	//스프링부트 실행순서
	//Spring boot 실행 -> Bean 생성 -> 의존성 주입 -> 
	//ApplicationContext 생성완료 -> CommandLineRunner.run() 실행
	
	private final Chef chef;
	
//	public ChefRunner(Chef chef) {
//		this.chef = chef;
//	}

	@Override
	public void run(String... args) throws Exception {
		chef.cook();
	}

}
