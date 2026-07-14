package com.korea.todo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//http응답으로 사용할 DTO
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDTO<T> {
	private String error;
	private List<T> data; 
	//다른 엔티티들도 ResponseDtO를 이용해 반환할 수 있도록
	//제네릭을 사용했다.
}
