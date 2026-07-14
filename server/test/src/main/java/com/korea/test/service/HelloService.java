package com.korea.test.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

	public String getHelloMessage(String name) {
		return "안녕하세요, "+name+"님!";
	}

}
