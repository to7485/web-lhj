package com.korea.architecture.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
//Lombok이 필요한 필드만 매개변수로 받는 생성자를 자동으로 만들어주는 어노테이션
// final이 붙은 필드
// @NonNull이 붙은 필드
public class Chef {
//의존성
//어떤 클래스가 다른 클래스의 기능을 사용해야 할 때, "의존 관계가 생겼다" 라고 한다.
	
//의존성 주입(Dependency Injection)
//클래스가 필요한 객체를 직접 생성하지 않고, 외부에서 전달받는 방식
//요리사는 칼이 필요하다 -> 요리사는 칼에 의존성이 있다.
	
	//필드 주입
	//멤버 변수(필드)에 직접 객체(의존성)를 주입하는 방식
	//객체를 생성할 때 어떤 의존성이 필요한지 한눈에 알기 어렵다
	//단위테스트가 어렵고 현재 권장하지 않는 방식
	//@Autowired
	private final Knife knife;
	private final Pan pan;
	private final Oven oven;
	private final Pot pot;
	
	//knife = new KitchenKnife();
	
	//세터(setter) 주입
	//setter 메서드를 통해 의존성을 주입하는 방식
	
	//의존성을 나중에 변경할 수 있다.
	//선택적으로 필요한 객체를 주입할 때 사용할 수 있다.
	
	//Setter를 호출하지 않으면 객체가 정상적으로 동작하지 않을 수 있다.
	//객체 생성시 의존성이 보장되지 않는다.
	//@Autowired
	//public void setKnife(Knife knife) {
	//	this.knife = knife;
	//}
	
	//생성자 주입
	//생성자를 이용하여 의존성을 전달하는 방식
	
	//객체가 생성되는 순간 의존성이 함께 주입된다.
	//의존성이 없으면 객체를 만들 수 없다.
	
	//final 사용 가능
	//의존성이 반드시 존재함이 보장된다.
	//테스트 하기 쉽다.
	//객체가 불변에 가깝게 설계된다.
	//스프링에서 가낭 권장하는 방식이다.
	
//생성자는 객체를 만들 때 호출 -> 스프링부트는 실행하면 객체를 만들어주네
//매개변수에 들어있는 변수들에게 주입
//	public Chef(Knife knife, Pan pan, Oven oven, Pot pot) {
//		this.knife = knife;
//		this.pan = pan;
//		this.oven = oven;
//		this.pot = pot;
//	}
	
	
	public void cook() {
		System.out.println("요리를 시작합니다.");
		knife.cut();
	}
	
	//필드 주입
	//객체 생성 -> 필드에 주입
	
	//setter 주입
	//객체 생성 -> Setter 호출 -> 주입
	
	//생성자 주입
	//객체생성하면서(생성자 호출) -> 동시에 주입
	
	
	
	
	
	
}
