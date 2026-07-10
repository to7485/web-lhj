package com.example.demo.di5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDiTest {
	public static void main(String[] args) {
		//스프링부트에 내장되어 있는 객체 컨테이너
		ApplicationContext ac = new AnnotationConfigApplicationContext("com.example.demo.di5");
		
		//컨테이너에 들어있는 자동차 객체를 꺼내온것.
		Car car = (Car)ac.getBean("car");
		
		//자동차 객체의 필드인 Engine과 Door에 객체가 주입되었다.
		System.out.println(car);
	}
}
