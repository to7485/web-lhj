package com.korea.test.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.korea.test.dto.BookDTO;
import com.korea.test.dto.ResponseDTO;
import com.korea.test.service.BookService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("books")
public class BookController {

	private final BookService bookService;
	
	//도서등록 POST
	//메서드명 : create
	@PostMapping
	public ResponseEntity<?> create(
			@RequestBody BookDTO dto){
		try {
			BookDTO result = bookService.create(dto);
			
			ResponseDTO<BookDTO> response = 
					ResponseDTO.<BookDTO>builder()
						.data(List.of(result))
						.build();
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			ResponseDTO<BookDTO> response = 
					ResponseDTO.<BookDTO>builder()
						.error(e.getMessage())
						.build();
			
			return ResponseEntity.ok().body(response);
		}

	}
	
	//전체도서 조회 GET
	//메서드명 : findAll
	@GetMapping
	public ResponseEntity<?> findAll(){
		try {
			List<BookDTO> data = bookService.findAll();
			
			ResponseDTO<BookDTO> response = 
					ResponseDTO.<BookDTO>builder()
						.data(data)
						.build();
			
			
			return ResponseEntity.ok().body(response);
			
			
		} catch (Exception e) {
			ResponseDTO<BookDTO> response = 
					ResponseDTO.<BookDTO>builder()
						.error(e.getMessage())
						.build();
			
			return ResponseEntity.ok().body(response);
		}
	}
	
	//ID로 도서 조회 GET
	//경로 GET /books/{id}
	//메서드명 : findById
	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		try {
			BookDTO result = bookService.findById(id);
			
			ResponseDTO<BookDTO> response = 
					ResponseDTO.<BookDTO>builder()
						.data(List.of(result))
						.build();
			return ResponseEntity.ok().body(response);
			
		} catch (Exception e) {
			ResponseDTO<BookDTO> response = 
					ResponseDTO.<BookDTO>builder()
						.error(e.getMessage())
						.build();
			
			return ResponseEntity.ok().body(response);
		}
	}
	
	//제목을 통한 조회
	//경로 GET /search?title=xxx
	@GetMapping("/search")
	public ResponseEntity<?> search(@RequestParam String title){
		System.out.println("제목 : " + title);
		try {
			List<BookDTO> data = bookService.findByTitle(title);
			
			ResponseDTO<BookDTO> response = 
					ResponseDTO.<BookDTO>builder()
						.data(data)
						.build();
			
			return ResponseEntity.ok().body(response);
			
		} catch (Exception e) {
			ResponseDTO<BookDTO> response = 
					ResponseDTO.<BookDTO>builder()
						.error(e.getMessage())
						.build();
			
			return ResponseEntity.ok().body(response);
		}
	}
	//카테고리별 조회
	//경로 GET /category?category=xx
	@GetMapping
	public ResponseEntity<?> findByCategory(@RequestParam String category){
		try {
			List<BookDTO> data = bookService.findByCategory(category);
			
			ResponseDTO<BookDTO> response = 
					ResponseDTO.<BookDTO>builder()
						.data(data)
						.build();
			
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			ResponseDTO<BookDTO> response = 
					ResponseDTO.<BookDTO>builder()
						.error(e.getMessage())
						.build();
			
			return ResponseEntity.ok().body(response);
		}
	}
	
	//도서 수정
	//경로 PUT {id}
	@PutMapping("{id}")
	public ResponseEntity<?> update(
			@PathVariable Long id,
			@RequestBody BookDTO dto){
		try {
			BookDTO result = bookService.update(id,dto);
			
			ResponseDTO<BookDTO> response = 
					ResponseDTO.<BookDTO>builder()
						.data(List.of(result))
						.build();
			
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			ResponseDTO<BookDTO> response = 
					ResponseDTO.<BookDTO>builder()
						.error(e.getMessage())
						.build();
			
			return ResponseEntity.ok().body(response);
		}
	}
	
	//도서 삭제
	//경로 DELETE {id}
	
	
}
