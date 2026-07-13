package com.korea.architecture.di.test;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class Patient {

	private String name = "홍길동";
	
	public void checkInformation() {
		System.out.println("환자"+name+"의 정보를 확인합니다.");
	}
}
