package com.korea.todo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.todo.dto.ResponseDTO;
import com.korea.todo.service.TodoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor //@NonNull이나 final가진 필드에 대해서 매개변수를 갖는 생성자를 만들어준다.
@RequestMapping("todo")
public class TodoController {

	//TodoService를 필드로 갖고 객체를 생성자 주입을 한다.
	private final TodoService todoService;
	
	//생성자 주입
//	public TodoController(TodoService todoService) {
//		this.todoService = todoService;
//	}
	
	// /test 로 요청이 들어오면 testTodo라는 메서드가 실행되고
	//서비스의 메서드를 실행하여 응답으로 반환한다.
	//ResponseEntity : HTTP 응답 전체를 표현하는 객체
	@GetMapping("/test")
	public ResponseEntity<?> testTodo() {
		String str = todoService.testService();
		List<String> list = new ArrayList<>();
		list.add(str);
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		//ok() -> 상태를 강제로 200으로 설정한다.
		//body() -> 응답본문에 response 객체를 넣는다.
		//완성된 HTTP응답을 클라이언트에게 전송한다.
		return ResponseEntity.ok().body(response);
		
		//Controller -> Service -> ResponseDTO -> ResponseEntity -> JSON
	}
}







