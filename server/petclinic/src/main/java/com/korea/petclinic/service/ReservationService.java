package com.korea.petclinic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.petclinic.dao.ReservationDAO;
import com.korea.petclinic.vo.ReservationVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {
	
	private final ReservationDAO reservationDAO;
	
	public List<ReservationVO> findAll() {
		return reservationDAO.findAll();
	}

	public int insert(ReservationVO vo) {
		return reservationDAO.insert(vo);
	}

}
