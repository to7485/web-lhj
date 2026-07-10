package com.example.demo.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class Coding {

	//@Autowired
	//private Computer computer;
	
	Computer computer;
	
	//생성자 주입
	//객체를 메모리에 올려주는 특수한 함수
	public Coding(Computer computer) {
		this.computer = computer;
	}
	
	
	
	
}
