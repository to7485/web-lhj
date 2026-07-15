package com.korea.test.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.test.dto.ResponseDTO;
import com.korea.test.dto.StudentDTO;
import com.korea.test.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/students")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;
	
	//수강생 조회
	@GetMapping
	public ResponseEntity<?> getStudents(){
		try {
			List<StudentDTO> students = studentService.getStudents();
			
			ResponseDTO<StudentDTO> response = ResponseDTO
													.<StudentDTO>builder()
													.error(null)
													.data(students)
													.build();
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			ResponseDTO<StudentDTO> response = ResponseDTO
					.<StudentDTO>builder()
					.error("수강생 목록 조회에 실패했습니다.")
					.build();
			return ResponseEntity.ok().body(response);
		}
		
	}
	

	//@RequestBody : 클라이언트가 HTTP 요청의 Body(본문)에 담아 보낸 데이터를
	//Java 객체로 변환해서 받기 위한 어노테이션
	
	//수강생등록
	@PostMapping
	public ResponseEntity<?> addStudent(
			@RequestBody StudentDTO studentDTO ){
		StudentDTO savedstudentDTO = studentService.addStudent(studentDTO);
		
		ResponseDTO<StudentDTO> response = ResponseDTO.<StudentDTO>builder().data(List.of(savedstudentDTO)).build();
		
		return ResponseEntity.ok().body(response);
	}
	
	
	
}







