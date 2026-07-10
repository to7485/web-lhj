package com.example.demo.di5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

	@Autowired
	Engine engine;
	
	@Autowired
	Door door;
	
	@Override
	public String toString() {
		return String.format("Car[engine= %s, door = %s]", engine, door);
	}
}
