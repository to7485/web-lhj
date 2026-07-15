package com.korea.architecture.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChefTest {
	
	//직접안함
	//Chef chef = new Chef();
	
	//프로젝트 실행하면 스프링부트가 만들어놓은 객체를 변수에 주입해준다.
	@Autowired
	Chef chef;
	

	@Test
	public void chefTest() {
		chef.cook();
	}
}
