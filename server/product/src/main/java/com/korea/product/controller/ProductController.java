package com.korea.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.product.service.ProductService;
import com.korea.product.vo.ProductVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;
	
	//상품조회
	@GetMapping
	public ResponseEntity<?> findAll(){
		List<ProductVO> result = productService.findAll();
		return ResponseEntity.ok().body(result);
	}
	
	//상품등록
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody ProductVO vo) {
		if(vo.getProductName() == null) {
			return ResponseEntity.badRequest().body("상품 이름을 입력하세요");
		}
		
		if(vo.getProductStock() < 0) {
			return ResponseEntity.badRequest().body("상품 재고는 0이상이어야 한다.");
		}
		
		if(vo.getProductPrice() <= 0) {
			return ResponseEntity.badRequest().body("상품 가격은 0보다 커야한다.");
		}
		
		List<ProductVO> result = productService.insert(vo);
		
		return ResponseEntity.ok().body(result);
		
	}
	
	//상품 한 건 조회
	@GetMapping("{productId}")
	public ResponseEntity<?> findById(@PathVariable int productId){
		ProductVO product = productService.findById(productId);
		return ResponseEntity.ok().body(product);
	}
	
	@PutMapping("{productId}")
	public ResponseEntity<?> update(
			@PathVariable int productId, 
			@RequestBody ProductVO vo){
		try {
			vo.setProductId(productId);
			return ResponseEntity.ok().body(productService.update(vo));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	
	
	
	
	
}
