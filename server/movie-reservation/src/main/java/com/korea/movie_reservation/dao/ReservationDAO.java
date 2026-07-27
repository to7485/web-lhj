package com.korea.movie_reservation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korea.movie_reservation.vo.ReservationVO;

@Mapper
public interface ReservationDAO {

	List<ReservationVO> findAll();
	
	void insert(ReservationVO vo);
	
	int update(ReservationVO vo);
	
	ReservationVO findReservationById(int reservationId);
	
}

