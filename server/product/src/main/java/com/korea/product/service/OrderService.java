package com.korea.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.product.dao.OrderDAO;
import com.korea.product.dao.ProductDAO;
import com.korea.product.vo.OrderVO;
import com.korea.product.vo.ProductVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderDAO orderDAO;
	private final ProductDAO productDAO;
	
	public List<OrderVO> findAll(){
		return orderDAO.findAll();
	}

	public List<OrderVO> insert(OrderVO vo) {
		
		//1. 주문수량을 검사
		if(vo.getProductCount() <= 0) {
			throw new IllegalArgumentException("주문 수량은 1개 이상이어야 합니다.");
		}
		
		//2. 상품 조회
		ProductVO product = productDAO.findById(vo.getProductId());
		
		//3. 상품 존재 여부를 검사
		if(product == null) {
			throw new IllegalArgumentException("상품이 존재하지 않습니다.");
		}
		
		//4. 재고검사
		if(product.getProductStock() < vo.getProductCount()) {
			throw new IllegalArgumentException("상품 재고가 부족합니다.");
		}
		
		//5. 주문 등록
		int orderResult = orderDAO.insert(vo);
		
		//6. 재고 차감
		int stockResult = productDAO.decreaseStock(vo.getProductId(), vo.getProductCount());
		
		return orderDAO.findAll();
	}

}
