package com.korea.movie_reservation.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.movie_reservation.service.ReservationService;
import com.korea.movie_reservation.vo.ReservationVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {
	
	private final ReservationService reservationService;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		List<ReservationVO> result = reservationService.findAll();
		return ResponseEntity.ok().body(result);
	}
	
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody ReservationVO vo) {
		if(vo.getCustomerName() == null) {
			return ResponseEntity.badRequest().body("예약자 이름을 입력하세요");
		}
		
		if(vo.getMovieId() == null) {
			return ResponseEntity.badRequest().body("영화 아이디를 입력하세요");
		}
		
		if(vo.getSeatNumber() == null) {
			return ResponseEntity.badRequest().body("좌석이 선택되지 않았습니다.");
		}
		
		if(vo.getTicketCount() <= 0) {
			return ResponseEntity.badRequest().body("예약할 티켓은 1장 이상이어야 합니다.");
		}
		
		List<ReservationVO> result = reservationService.insert(vo);
		
		return ResponseEntity.ok().body(result);
		
	}
	
	@PutMapping("{reservationId}")
	public ResponseEntity<?> update(
			@PathVariable int reservationId, 
			@RequestBody ReservationVO vo){
		try {
			vo.setReservationId(reservationId);
			return ResponseEntity.ok().body(reservationService.update(vo));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
}
