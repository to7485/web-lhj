package com.korea.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.korea.test.entity.BookEntity;

//JpaRepository<BookEntity, Long> 상속받으면 Repository로 취급한다.
@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long>{

	//특정 제목이 포함된 데이터를 조회하는 메서드
	List<BookEntity> findByTitleContaining(String title);
	
	//카테고리가 일치하는 도서 검색
	List<BookEntity> findByCategory(String category);
	
	
	
	
	
	
}
