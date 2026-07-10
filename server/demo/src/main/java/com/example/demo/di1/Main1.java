package com.example.demo.di1;

import java.io.FileReader;
import java.util.Properties;

class Car{};
class SportCar extends Car{};
class Truck extends Car{};
class Engine{};

public class Main1 {
	public static void main(String[] args) throws Exception {
		//객체가 필요하다(필드, 메서드를 사용하기 위해서)
		//SportCar car = new SportCar();
		//변경사항이 발생했을 때 타입이랑 생성자 부분을 모두 변경해줘야 한다.
		//다형성을 이용하면 수정을 해야 하는 곳이 적어진다.
		//Car car = new Truck();
		
		//별도의 메서드를 만들어서 객체를 수정하면 수정포인트를 더 줄일 수 있다.
		//getCar()메서드를 사용하는 쪽에서는 한번에 바뀌게 된다.
		//Car car = getCar();
		
		//모든 코드들은 구체적 -> 추상적
		
		Car car = (Car)getObject("car");
		Engine engine = (Engine)getObject("engine");
		
		
	}
	
	static Object getObject(String key) throws Exception {
		
		//키와 값의 쌍으로 구성된 속성 목록을 관리할 때 사용
		Properties p = new Properties();
		
		//load메서드가 어떤 파일에서 데이터를 읽어오는것
		p.load(new FileReader("config.txt"));
		
		//클래스의 정보를 얻어와서
		Class clazz = Class.forName(p.getProperty(key));
		
		return clazz.newInstance(); //객체를 생성해서 반환
	}
}







