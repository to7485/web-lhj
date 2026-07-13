package com.korea.architecture.di;

import org.springframework.stereotype.Component;

//해당 클래스를 스프링이 관리하는 객체로 등록
//스프링이 관리하는 객체를 bean이라고 한다.
//서버가 실행 될때 객체가 자동으로 생성된다.
@Component
public class KitchenKnife implements Knife {

	@Override
	public void cut() {
		System.out.println("주방용 칼로 재료를 손질합니다.");
	}

}
