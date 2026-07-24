package com.korea.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korea.product.vo.OrderVO;

@Mapper
public interface OrderDAO {

	int insert(OrderVO vo);

	List<OrderVO> findAll();

}
