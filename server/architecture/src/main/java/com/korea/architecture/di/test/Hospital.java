package com.korea.architecture.di.test;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Hospital {

	private final Doctor doctor;
	
	public void startMedicalService() {
		System.out.println("병원 진료 업무를 시작합니다");
		doctor.treat();
		System.out.println("병원 진료 업무를 종료합니다.");
	}
}






