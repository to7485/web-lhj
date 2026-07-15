package com.korea.todo.service;

import org.springframework.stereotype.Service;

import com.korea.todo.entity.TodoEntity;
import com.korea.todo.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

//비즈니스 계층
//표현계층과 영속계층 사이에서 비즈니스 로직을 수행하는 역할을 한다.
//HTTP와 긴밀히 연결된 컨트롤러에서 분리돼 있고, 또 데이터베이스와 긴밀히 연결된
//영속계층과도 분리되어 있다.
//따라서 우리가 개발하고자 하는 로직에 집중할 수 있다.

@Service //스프링 bean으로 등록되어 다른 클래스에 주입될 수 있다.
@RequiredArgsConstructor
public class TodoService {
	
	private final TodoRepository repository;
	
	
	
	

	public String testService() {
		
		//엔티티 생성
		TodoEntity entity = TodoEntity.builder().title("My first todo item").build();
		
		//TodoEntity 저장
		repository.save(entity);
		
		//TodoEntity 검색
		TodoEntity savedEntity = repository.findById(entity.getId()).get();
		
		//Optional
		//Java 8에서 도입된 클래스로, null값을 안전하게 처리하기 위한 용도로 사용이 된다.
		//findById()메서드의 결과가 존재 할 수도 있고, 존재하지 않을 수도 있기 때문에
		//null을 반환하는 대신 Optional을 사용하여 결과를 감싸서 반환한다.
		//Optional은 해당 엔티티가 존재하는 지 여부를 확인하고, 존재하면 그 값을 반환하며,
		//존재하지 않을 경우 추가적인 처리를 할 수 있는 다양한 메서드를 활용한다.
		
		//isPresent() : 반환된 Optional 객체 안에 값이 존재하면 true, 아니면 false
		
		//get() : Optional안에 값이 존재할 때 그 값을 반환한다.
		//만약 값이 없는데 get()을 호출하면 NoSuchElementException이 발생할 수 있다.
		
		//orElse(T other) : 값이 존재하지 않을 때 기본값을 반환한다.
		
		//반환형이 Optional인 이유
		//조회하려는 ID가 존재하지 않을 수 있기 때문이다.
		
		return savedEntity.getTitle();
	}
}





