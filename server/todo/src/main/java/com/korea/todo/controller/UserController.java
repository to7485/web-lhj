package com.korea.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.todo.dto.ResponseDTO;
import com.korea.todo.dto.UserDTO;
import com.korea.todo.entity.UserEntity;
import com.korea.todo.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController {

	private final UserService userService;
	
	//회원가입
	//경로 : /signup
	//메서드 : registerUser
	//요청으로부터 넘어온 내용을 받아서 데이터베이스에 추가하고, 추가된 내용을 UserDTO에 담아서 반환하기
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody UserDTO dto){
		try {
			UserEntity user = UserEntity.builder()
									.username(dto.getUsername())
									.password(dto.getPassword())
									.build();
			
			UserEntity registeredUser = userService.create(user);
			
			UserDTO responseUserDTO = UserDTO.builder()
										.id(registeredUser.getId())
										.username(registeredUser.getUsername())
										.build();
			
			return ResponseEntity.ok(responseUserDTO);
		} catch (Exception e) {
			ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
			
			return ResponseEntity.badRequest().body(responseDTO);
		}
	}
	
	
	//로그인하기
	//경로 POST /signin
	//메서드명 authenticate
	//입력받은 아이디와 비밀번호를 받아서 검증하고 조회된 유저를 반환
	
	
	
	
	
	
}
