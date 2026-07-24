package com.korea.petclinic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korea.petclinic.vo.ReservationVO;
import com.korea.petclinic.vo.StatusCountVO;

@Mapper
public interface ReservationDAO {

	public List<ReservationVO> findAll();

	public int insert(ReservationVO vo);

	public ReservationVO findById(Long id);

	public int update(ReservationVO vo);

	public int delete(Long id);

	public List<ReservationVO> searchDetail(String searchType, String keyword);

	public List<ReservationVO> findAllSort(String sort);

	public Integer getTotalPrice();

	public List<StatusCountVO> getStatusCount();

}
