package com.korea.todo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.korea.todo.dto.ResponseDTO;
import com.korea.todo.dto.TodoDTO;
import com.korea.todo.entity.TodoEntity;
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
	
	//요청 -> (DTO -> Entity) TodoController -> TodoService
	//추가하기 위해 데이터가 넘어왔다.
	//매개변수로 받는다.
	//엔티티로 변경하고 service로 보낸다.
	//비즈니스 로직을 실행하고 난 결과를 받아온다.
	//응답으로 내보낸다.
	@PostMapping
	public ResponseEntity<?> createTodo(@AuthenticationPrincipal String userId, @RequestBody TodoDTO dto){
		try {
			
			//dto -> entity
			TodoEntity entity = TodoDTO.toEntity(dto);
			
			entity.setUserId(userId);
			
			//서비스레이어의 create 메서드를 호출하여, TodoEntity를 데이터베이스 저장
			List<TodoEntity> entities = todoService.create(entity);
			
			//자바 스트림을 이용해 반환된 엔티티 리스트를 TodoDTO타입의 리스트로 변환
			List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).toList();
			
			//변환된 TodoDTO리스트를 이용해 ResponseDTO의 data에 리스트를 넣는다.
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
			
			return ResponseEntity.ok().body(response);
			
		} catch (Exception e) {
			//예외가 발생하는 경우 dto대신 error에 메시지를 넣어 반환한다.
			String error = e.getMessage();
			
			//에러 메시지를 포함한 ResponseDTO 객체 만들기
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
			
			//badRequest() : 400 Bad Request 상태코드를 가진 응답을 반환한다.
			//이는 클라이언트가 잘못 요청을 했음을 나타낸다.
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	//전체조회 기능
	@GetMapping
	public ResponseEntity<?> retrieveTodoList(@AuthenticationPrincipal String userId){
		//String temporaryUserId = "temporary-user"; //임시 유저 아이디
		
		List<TodoEntity> entities = todoService.retrieve(userId);
		
		//List에 들어있는 데이터를 TodoDTO타입으로 바꾸고 ResponseDTO에 넣어서 응답으로 내보내기
		//자바 스트림을 이용해 반환된 엔티티 리스트를 TodoDTO타입의 리스트로 변환
		List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).toList();
		
		//변환된 TodoDTO리스트를 이용해 ResponseDTO의 data에 리스트를 넣는다.
		ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
		
		return ResponseEntity.ok().body(response);
	}
	
	//할일 수정하기
	//findById(), save()를 활용하기
	//메서드명 updateTodo
	@PutMapping
	public ResponseEntity<?> updateTodo(@AuthenticationPrincipal String userId, @RequestBody TodoDTO dto){
		
		TodoEntity entity = TodoDTO.toEntity(dto);
		
		entity.setUserId(userId);
		
		List<TodoEntity> entities = todoService.update(entity);
		
		//List에 들어있는 데이터를 TodoDTO타입으로 바꾸고 ResponseDTO에 넣어서 응답으로 내보내기
		//자바 스트림을 이용해 반환된 엔티티 리스트를 TodoDTO타입의 리스트로 변환
		List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).toList();
		
		//변환된 TodoDTO리스트를 이용해 ResponseDTO의 data에 리스트를 넣는다.
		ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
		
		return ResponseEntity.ok().body(response);
	}
	
	
	//삭제하기
	@DeleteMapping
	public ResponseEntity<?> deleteTodo(@AuthenticationPrincipal String userId, @RequestBody TodoDTO dto){
		try {
			
			TodoEntity entity = TodoDTO.toEntity(dto);
			
			entity.setUserId(userId);
			
			List<TodoEntity> entities = todoService.delete(entity);
			
			List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).toList();
			
			//변환된 TodoDTO리스트를 이용해 ResponseDTO의 data에 리스트를 넣는다.
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
			
			return ResponseEntity.ok().body(response);
			
			
			
			
		} catch (Exception e) {
			//예외가 발생하는 경우 dto대신 error에 메시지를 넣어 반환한다.
			String error = e.getMessage();
			
			//에러 메시지를 포함한 ResponseDTO 객체 만들기
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
			
			//badRequest() : 400 Bad Request 상태코드를 가진 응답을 반환한다.
			//이는 클라이언트가 잘못 요청을 했음을 나타낸다.
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	
	
	
	
	
	
}







