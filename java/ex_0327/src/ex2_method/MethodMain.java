package ex2_method;

import java.util.Arrays;

public class MethodMain {
	public static void main(String[] args) {
		//클래스 안에 정의된 메서드 사용하기
		
		//1. 객체가 정의되어야 한다.
		MethodExample m = new MethodExample();
		
		//2. 객체를 통해서 메서드를 호출해야 한다.
		//변수명.메서드명();
		m.printInfo();
		
		//메서드의 호출
		int result = m.add(10, 7);
		System.out.println(result);
		
		System.out.println(m.add(2, 4));
		
		//메서드의 호출
		m.circleArea(5);
		
		m.circleRound(5);
		
		int result2 = m.countChar("apple", 'p');
		System.out.println("p의 개수 : " + result2);
		
	}
}







