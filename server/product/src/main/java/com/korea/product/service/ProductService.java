package com.korea.product.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import com.korea.product.dao.ProductDAO;
import com.korea.product.vo.ProductVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductDAO productDAO;

	public List<ProductVO> insert(ProductVO vo) {
		productDAO.insert(vo);
		
		return productDAO.findAll();
	}

	public List<ProductVO> findAll() {
		return productDAO.findAll();
	}

	public ProductVO findById(int productId) {
		return productDAO.findById(productId);
	}

	public List<ProductVO> update(ProductVO vo) {
		//제품이 있는지 확인
		ProductVO product = productDAO.findById(vo.getProductId());
		
		if(product == null) {
			throw new IllegalArgumentException("수정할 상품이 존재하지 않습니다.");
		}
		
		productDAO.update(vo);
		
		return productDAO.findAll();
	}
}











