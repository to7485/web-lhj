package com.korea.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korea.product.vo.ProductVO;

@Mapper
public interface ProductDAO {

	List<ProductVO> findAll();

	void insert(ProductVO vo);

	ProductVO findById(int productId);

	int update(ProductVO vo);

	int decreaseStock(int productId, int productCount);

}
