package ex1_overriding;

//부모클래스
public class Calculator {

	//반지름을 외부에서 받아 원의 넓이를 반환하는 areaCircle메서드 작성하기
	//원의 넓이 : 3.14 * 반지름 * 반지름
	
	//메서드의 구조
	//접근제한자 반환타입 메서드명(매개변수){
	//	
	//}
	
	public double areaCircle(double r) {
		System.out.println("Calculator 객체의 areaCircle() 실행");
		return 3.14159 * r * r;
	}
	
	
	
	
	
	
	
	
	
}
