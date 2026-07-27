package com.korea.movie_reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.movie_reservation.dao.MovieDAO;
import com.korea.movie_reservation.vo.MovieVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {
	
	private final MovieDAO movieDAO;
	
	public List<MovieVO> findAll() {
		return movieDAO.findAll();
	}

	public List<MovieVO> insert(MovieVO vo) {
		movieDAO.insert(vo);
		
		return movieDAO.findAll();
	}
	
	public MovieVO findMovieById(int reservationId) {
		return movieDAO.findMovieById(reservationId);
	}
}

