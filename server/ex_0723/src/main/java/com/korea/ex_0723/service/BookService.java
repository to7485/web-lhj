package com.korea.ex_0723.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.ex_0723.dao.BookDAO;
import com.korea.ex_0723.vo.BookVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

	private final BookDAO bookDAO;
	
	public List<BookVO> findAll(){
		return bookDAO.findAll();
	}
	
	public BookVO findById(Long id) {
		return bookDAO.findById(id);
	}
	
	public int insert(BookVO vo) {
		return bookDAO.insert(vo);
	}
	
	public int update(BookVO vo) {
		return bookDAO.update(vo);
	}

	public int delete(Long id) {
		return bookDAO.delete(id);
	}

	public List<BookVO> findByCategory(String name) {
		return bookDAO.findByCategory(name);
	}

	public List<BookVO> findByTitle(String title) {
		return bookDAO.findByTitle(title);
	}

	public int count() {
		return bookDAO.count();
	}
	
	public List<BookVO> findAllOrder(String sort){
		return bookDAO.findAllOrder(sort);
	}
	
	
	
	
	
	
}
