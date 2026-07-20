package com.korea.todo.service;

import org.springframework.stereotype.Service;

import com.korea.todo.entity.UserEntity;
import com.korea.todo.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

	private final UserRepository repository;
	
	//회원가입 기능
	public UserEntity create(UserEntity user) {
		if(user == null || user.getUsername() == null) {
			throw new RuntimeException("Invalid arguments");
		}
		
		final String username = user.getUsername();
		
		//username이 이미 존재하는 경우, 경고 로그를 남기고 예외를 던진다.
		if(repository.existsByUsername(username)) {
			log.warn("Username already exists {}", username);
			throw new RuntimeException("Username already exists");
		}
		
		return repository.save(user);
	}
	
	
	
	
	
	
	
	
	
	
}
