package com.korea.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.test.dto.BookDTO;
import com.korea.test.entity.BookEntity;
import com.korea.test.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

	private final BookRepository bookRepository;

	public BookDTO create(BookDTO dto) {
		BookEntity entity = BookEntity.builder()
				.title(dto.getTitle())
				.author(dto.getAuthor())
				.price(dto.getPrice())
				.category(dto.getCategory())
				.stock(dto.getStock())
				.build();
		
		BookEntity savedEntity = bookRepository.save(entity);
		return new BookDTO(savedEntity);
	}

	public List<BookDTO> findAll() {
		
		List<BookDTO> list = bookRepository.findAll()
									.stream()
									.map(BookDTO::new)
									.toList();
		
		System.out.println(list);
		
		return list;
	}
	
	public BookDTO findById(Long id) {
		
		BookEntity entity = bookRepository.findById(id).get();
		
		return new BookDTO(entity);
	}
	
	public List<BookDTO> findByTitle(String title){
		return bookRepository
				.findByTitleContaining(title)
				.stream()
				.map(BookDTO::new)
				.toList();
	}
	
	public List<BookDTO> findByCategory(String category){
		return bookRepository
				.findByCategory(category)
				.stream()
				.map(BookDTO::new)
				.toList();
	}
	
	public BookDTO update(Long id, BookDTO dto) {
		
		//id를 통해서 꺼내온 원본
		BookEntity entity = 
				bookRepository.findById(id).get();
		
		//dto 수정할 값을을 entity에 넣는다.
		entity.setTitle(dto.getTitle());
		entity.setAuthor(dto.getAuthor());
		entity.setPrice(dto.getPrice());
		entity.setCategory(dto.getCategory());
		entity.setStock(dto.getStock());
		
		BookEntity savedEntity = 
				bookRepository.save(entity);
		
		return new BookDTO(savedEntity);
	}
	
	
}








