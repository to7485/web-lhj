package com.korea.petclinic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.petclinic.dao.ReservationDAO;
import com.korea.petclinic.vo.ReservationVO;
import com.korea.petclinic.vo.StatusCountVO;

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

	public ReservationVO findById(Long id) {
		return reservationDAO.findById(id);
	}

	public int update(ReservationVO vo) {
		return reservationDAO.update(vo);
	}

	public int delete(Long id) {
		return reservationDAO.delete(id);
	}

	public List<ReservationVO> searchDetail(String searchType, String keyword) {
		return reservationDAO.searchDetail(searchType,keyword);
	}

	public List<ReservationVO> findAllSort(String sort) {
		return reservationDAO.findAllSort(sort);
	}

	public Integer getTotalPrice() {
		return reservationDAO.getTotalPrice();
	}

	public List<StatusCountVO> getStatusCount() {
		return reservationDAO.getStatusCount();
	}

}
