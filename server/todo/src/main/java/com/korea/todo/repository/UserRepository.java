package com.korea.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.korea.todo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

	//전달한 아이디를 가지는 데이터를 조회
	UserEntity findByUsername(String username);
	
	//전달한 아이디를 가지는 데이터가 있는지 검사
	Boolean existsByUsername(String username);
	
	//전달한 아이디와 비밀번호를 가지는 데이터를 조회
 	UserEntity findByUsernameAndPassword(String username, String password);
}










