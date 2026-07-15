package com.korea.todo.dto;

import com.korea.todo.entity.TodoEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//서비스가 요청을 처리하고 클라이언트로 반환할 때, Entity 자체를 반환하는 경우는
//많이 없다
//보통은 데이터를 전달하기 위해 사용하는 객체인 DTO로 변환해 반환한다.
//DTO로 변환하여 반환하는 이유
//1. 비즈니스 로직을 캡슐화 하기 위함이다.
//대부분의 회사들은 외부인이 자사의 DB 스키마를 아는 것을 원하지 않는다.
//이때 DTO처럼 다른 객체로 바꿔 반환하면 외부 사용자에게 서비스 내부의 로직,
//DB 구조등을 숨길 수 있다.
//2. 클라이언트가 필요한 정보를 모델이 전부 포함하지 않는 경우가 있다.
//대표적으로 에러메시지가 있다.
//만약 서비스 실행 도중 유저 에러가 나면 에러 메시지를 어디에 포함할것인가
//Entity에는 서비스 로직과 관련이 없기 때문에 다른 내용을 담기가 애매하다
//이런 경우 DTO에 에러 메시지 필드를 선언하고 DTO에 메시지를 넣어서 전달하면 된다.
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
	private Long id;
	private String title;
	private boolean done;
	
	//사용자의 요청을 받아서 데이터들을 DTO객체에 넣는다.
	//DB에 전달할 때는 무조건 Entity타입이어야한다.
	public TodoDTO(final TodoEntity entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.done = entity.isDone();
	}
	
	
	
	
	
	
	
	
}





