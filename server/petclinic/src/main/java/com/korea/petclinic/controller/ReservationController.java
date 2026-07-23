package com.korea.petclinic.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.petclinic.service.ReservationService;
import com.korea.petclinic.vo.ReservationVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("reservation")
@RequiredArgsConstructor
public class ReservationController {

	private final ReservationService reservationService;
	
	//전체조회
	@GetMapping
	public List<ReservationVO> findAll(){
		return reservationService.findAll();
	}
	
	@PostMapping
	public int insert(@RequestBody ReservationVO vo) {
		return reservationService.insert(vo);
	}
	
	
	
	
	
	
	
	
	
	
	
}
