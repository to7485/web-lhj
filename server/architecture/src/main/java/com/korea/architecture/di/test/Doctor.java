package com.korea.architecture.di.test;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Doctor {

	private final Patient patient;
	
	public void treat() {
		patient.checkInformation();
		System.out.println(patient.getName()+"진료가 완료되었습니다");
	}
}
