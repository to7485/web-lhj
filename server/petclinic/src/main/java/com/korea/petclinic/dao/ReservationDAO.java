package com.korea.petclinic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korea.petclinic.vo.ReservationVO;

@Mapper
public interface ReservationDAO {

	public List<ReservationVO> findAll();

	public int insert(ReservationVO vo);

}
