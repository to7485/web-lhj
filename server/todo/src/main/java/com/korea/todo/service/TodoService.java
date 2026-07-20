package com.korea.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.korea.todo.entity.TodoEntity;
import com.korea.todo.repository.TodoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//비즈니스 계층
//표현계층과 영속계층 사이에서 비즈니스 로직을 수행하는 역할을 한다.
//HTTP와 긴밀히 연결된 컨트롤러에서 분리돼 있고, 또 데이터베이스와 긴밀히 연결된
//영속계층과도 분리되어 있다.
//따라서 우리가 개발하고자 하는 로직에 집중할 수 있다.

@Service //스프링 bean으로 등록되어 다른 클래스에 주입될 수 있다.
@RequiredArgsConstructor
@Slf4j //롬복에서 온 로그를 사용할 수 있게 해주는 어노테이션
//trace : 가장 상세한 실행 정보
//debug : 개발 및 디버깅 정보
//info : 일반적인 실행 정보
//warn : 경고 상황
//error : 오류 상황
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
	
	//할일 추가
	//1. 넘어온 엔티티가 유효한지 검사
	//2. 엔티티를 데이터베이스에 저장 -> 로그를 남긴다.
	//3. findByUserId()를 통해 저장된 엔티티를 포함하는 새 리스트를 반환
	public List<TodoEntity> create(TodoEntity entity){
		validate(entity);
		
		//전달된 entity를 데이터베이스에 저장한다.
		repository.save(entity);
		log.info("Entity Id : {} is saved",entity.getId());
		
		return repository.findByUserId(entity.getUserId()); 
	}
	
	//전체조회
	//retrieve메서드 만들기
	
	
	

	public List<TodoEntity> retrieve(String temporaryUserId) {
		return repository.findByUserId(temporaryUserId);
	}


	//수정하기
	//update
	public List<TodoEntity> update(TodoEntity entity) {
		validate(entity);
		
		//넘겨받은 엔티티 id를 통해 TodoEntity 한 개를 가져온다.
		//존재하지 않는 엔티티는 수정할 수 없기 때문이다.
		Optional<TodoEntity> original = repository.findById(entity.getId());
		
		original.ifPresent(todo -> {
			//반환된 TodoEntity가 존재하면 값을 새 Entity값으로 덮어씌운다.
			todo.setTitle(entity.getTitle());
			todo.setDone(entity.isDone());
			
			//수정된 내용을 담은 todo를 다시 데이터베이스에 넣는다.
			repository.save(todo);
		});
		
		
		//수정된 데이터를 반영한 전체조회
		return retrieve(entity.getUserId());
	}
	
	private void validate(TodoEntity entity) {
		//null인지 확인
		if(entity == null) {
			log.warn("Entity cannot be null");
			throw new RuntimeException("Entity cannot be null");
		}
		
		//entity의 userId값이 들어있는지 확인
		if(entity.getUserId() == null) {
			log.warn("Unknown user");
			throw new RuntimeException("Unknown user");
		}
	}

	public List<TodoEntity> delete(TodoEntity entity) {
		validate(entity);
		
		try {
			repository.delete(entity);
		} catch (Exception e) {
			log.error("error deleting entity ",entity.getId(), e);
			
			throw new RuntimeException("error deleting entity " + entity.getId());
		}
		
		return retrieve(entity.getUserId());
	}
	
	
	
}





