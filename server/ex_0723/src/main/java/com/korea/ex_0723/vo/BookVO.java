package com.korea.ex_0723.vo;

import lombok.Data;

@Data
public class BookVO {

	private Long id;
	private String author;
	private String title;
	private String category;
	private int price;
	private int stock;
}
