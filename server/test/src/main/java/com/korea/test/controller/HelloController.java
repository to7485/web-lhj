package com.korea.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.korea.test.service.HelloService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class HelloController {
	
	private final HelloService helloService;

	@GetMapping("hello")
	public String hello(@RequestParam String name) {
		System.out.println("이름 : " + name);
		return helloService.getHelloMessage(name);
	}
}





