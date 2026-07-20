package com.korea.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.korea.todo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

	UserEntity findByUsername(String username);
	
	Boolean existsByUsername(String username);
	
 	UserEntity findByUsernameAndPassword(String username, String password);
}
