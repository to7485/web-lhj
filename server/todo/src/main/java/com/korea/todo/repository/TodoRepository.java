package com.korea.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.korea.todo.entity.TodoEntity;

@Repository 
//주로 데이터베이스와 상호작용하는 클래스에서 사용되며, CRUD와 같은 데이터베이스작업을 처리하는데 사용된다.
//스프링이 Bean으로 등록한다.
//다른 계층에서 주입받아 사용할 수 있다.
//JpaRepository<T, ID>
//Spring Data JPA에서 제공하는 기본 인터페이스로  JPA를 사용하여 데이터베이스 작업을
//쉽게 처리할 수 있도록 도와주는 역할을 한다.
//이 인터페이스는 CRUD 기능과 페이징, 정렬같은 데이터 처리 기능을 기본적으로 제공한다.
//T : 엔티티 클래스(데이터베이스 테이블과 매핑되는 클래스)를 의미한다.
//ID : 엔티티 클래스의 기본 키 타입을 의미한다.
public interface TodoRepository extends JpaRepository<TodoEntity, Long>{

	//주요 메서드
	//save(S entity) : 엔티티를 데이터베이스에 저장하거나 업데이트한다.
	//findById(ID id) : 기본키를 이용하여 엔티티를 조회한다.
	//findAll() : 데이터베이스의 모든 엔티티를 조회한다.
	//deleteById(ID id) : 기본 키를 이용하여 엔티티를 삭제한다.
	
	
	// ?뒤에 1은 메서드의 첫번째 매개변수를 사용하겠다는 의미
	
	
	//SELECT * FROM todo where userid = ?1
	@Query("Select t from TodoEntity t WHERE t.userId = ?1")
	List<TodoEntity> findByUserIdQuery(Long userId);
}










