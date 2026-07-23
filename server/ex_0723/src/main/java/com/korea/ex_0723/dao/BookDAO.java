package com.korea.ex_0723.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.korea.ex_0723.vo.BookVO;

@Mapper
public interface BookDAO {

	//전체조회
	List<BookVO> findAll();
	
	//단건조회
	BookVO findById(Long id);
	
	//도서 추가
	int insert(BookVO vo);
	
	//도서 수정
	int update(BookVO vo);

	int delete(Long id);

	List<BookVO> findByCategory(String name);

	List<BookVO> findByTitle(String title);

	int count();
	
	List<BookVO> findAllOrder(@Param("sort") String sort);
}







