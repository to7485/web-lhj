package com.korea.product.vo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderVO {

	private int orderId;
	private int productId;
	private String productName;
	private int productPrice;
	private int productCount;
	private int totalPrice;
	private LocalDateTime orderDate;
}
