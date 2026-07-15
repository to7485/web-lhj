package com.korea.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.test.dto.StudentDTO;

@Service
public class StudentService {

	List<StudentDTO> list = new ArrayList<>();
	
	private Integer sequence = 1;
	
	public StudentService() {
		list.add(
				StudentDTO.builder()
				.id(sequence++)
				.name("홍길동")
				.email("hong@gmail.com")
				.course("자바 웹 개발")
				.build());
		list.add(
				StudentDTO.builder()
				.id(sequence++)
				.name("김철수")
				.email("kim@gmail.com")
				.course("클라우드 개발")
				.build());
	}
	
	//수강생 조회
	//데이터베이스에 연결하는게 아니니 ArrayList를 하나 만들고 
	//임의의 데이터 두개를 추가하기
	
	public List<StudentDTO> getStudents(){
		return list;
	}
	
	public StudentDTO addStudent(StudentDTO studentDTO) {
		StudentDTO newStudent = StudentDTO.builder()
									.id(sequence++)
									.name(studentDTO.getName())
									.course(studentDTO.getCourse())
									.email(studentDTO.getEmail())
									.build();
		list.add(newStudent);
		
		return newStudent;
	}
}






