package com.example.demo.dependency.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("labtop")
public class Laptop implements Computer{

	@Override
	public int getScreenWidth() {
		// TODO Auto-generated method stub
		return 1600;
	}

}
