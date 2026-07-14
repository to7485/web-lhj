package com.korea.todo.service;

import org.springframework.stereotype.Service;

//비즈니스 계층
//표현계층과 영속계층 사이에서 비즈니스 로직을 수행하는 역할을 한다.
//HTTP와 긴밀히 연결된 컨트롤러에서 분리돼 있고, 또 데이터베이스와 긴밀히 연결된
//영속계층과도 분리되어 있다.
//따라서 우리가 개발하고자 하는 로직에 집중할 수 있다.

@Service //스프링 bean으로 등록되어 다른 클래스에 주입될 수 있다.
public class TodoService {

	public String testService() {
		return "Test Service";
	}
}





