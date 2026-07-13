package com.example.demo.dependency.qualifier;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class ComputerTest {

	private final Computer laptop;
	
	public ComputerTest(@Qualifier("labtop") Computer laptop) {
		this.laptop = laptop;
	}
	
	@Test
	public void computerTest() {
		log.info(laptop.getScreenWidth()+"");
	}
	
}
