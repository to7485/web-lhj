package com.korea.movie_reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.movie_reservation.dao.ReservationDAO;
import com.korea.movie_reservation.vo.MovieVO;
import com.korea.movie_reservation.vo.ReservationVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {

	private final ReservationDAO reservationDAO;
	
	public List<ReservationVO> findAll() {
		return reservationDAO.findAll();
	}
	
	public List<ReservationVO> insert(ReservationVO vo){
		reservationDAO.insert(vo);
		
		return reservationDAO.findAll();
	}
	
	public List<ReservationVO> update(ReservationVO vo) {
		ReservationVO product = reservationDAO.findReservationById(vo.getReservationId());
		
		if(product == null) {
			throw new IllegalArgumentException("수정할 예매가 존재하지 않습니다.");
		}
		
		reservationDAO.update(vo);
		
		return reservationDAO.findAll();
	}
}
