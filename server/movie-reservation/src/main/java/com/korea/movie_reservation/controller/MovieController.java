package com.korea.movie_reservation.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.movie_reservation.service.MovieService;
import com.korea.movie_reservation.vo.MovieVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {

private final MovieService movieService;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		List<MovieVO> result = movieService.findAll();
		return ResponseEntity.ok().body(result);
	}
	
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody MovieVO vo) {
		if(vo.getMovieTitle() == null) {
			return ResponseEntity.badRequest().body("영화 이름을 입력하세요");
		}
		
		if(vo.getMovieGenre() == null) {
			return ResponseEntity.badRequest().body("영화 장르를 입력하세요");
		}
		
		if(vo.getRunningTime() < 0) {
			return ResponseEntity.badRequest().body("영화 상영 시간은 0분 이상이어야 한다.");
		}
		
		if(vo.getTicketPrice() <= 0) {
			return ResponseEntity.badRequest().body("티켓 가격은 0원보다 비싸야한다.");
		}
		
		List<MovieVO> result = movieService.insert(vo);
		
		return ResponseEntity.ok().body(result);
		
	}
	
	@GetMapping("{MovieId}")
	public ResponseEntity<?> findMovieById(@PathVariable int MovieId){
		MovieVO reservation = movieService.findMovieById(MovieId);
		return ResponseEntity.ok().body(reservation);
	}
	
}
