package com.korea.product.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.product.service.OrderService;
import com.korea.product.vo.OrderVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController {
	
	private final OrderService orderService;
	
	//주문내역 조회
	@GetMapping
	public ResponseEntity<?> findAll(){
		try {
			return ResponseEntity.ok().body(orderService.findAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	//주문하기
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody OrderVO vo){
		try {
			return ResponseEntity.ok().body(orderService.insert(vo));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	

}
