package com.korea.ex_0723.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.korea.ex_0723.service.BookService;
import com.korea.ex_0723.vo.BookVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("books")
public class BookController {

	private final BookService bookService;
	
	@GetMapping
	public List<BookVO>findAll(){
		return bookService.findAll();
	}
	
	@GetMapping("{id}")
	public BookVO findById(@PathVariable Long id) {
		return bookService.findById(id);
	}
	
	@PostMapping
	public int insert(@RequestBody BookVO vo) {
		return bookService.insert(vo);
	}
	
	@PutMapping("{id}")
	public int update(@RequestBody BookVO vo, @PathVariable Long id) {
		vo.setId(id);
		return bookService.update(vo);
	}
	
	@DeleteMapping("{id}")
	public int delete(@PathVariable Long id) {
		return bookService.delete(id);
	}
	
	//카테고리별 도서 조회
	//GET /books/category?name=프로그래밍
	//메서드명 : findByCategory
	@GetMapping("/category")
	public List<BookVO> findByCategory(@RequestParam String name){
		return bookService.findByCategory(name);
	}
	
	@GetMapping("/search")
	public List<BookVO> findByTitle(@RequestParam String title){
		return bookService.findByTitle(title);
	}
	
	@GetMapping("count")
	public int count() {
		return bookService.count();
	}
	
	@GetMapping("sort/{sort}")
	public List<BookVO> findAllOrder(@PathVariable String sort){
		return bookService.findAllOrder(sort);
	}
	
	
	
	
	
	
}
