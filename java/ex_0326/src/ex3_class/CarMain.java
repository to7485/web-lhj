package ex3_class;

public class CarMain {
	public static void main(String[] args) {
		//Scanner는 자바에서 제공하는 클래스라는 점
		//Scanner 변수명 = new Scanner();
		Car c = new Car(); //자동차를 1대 만듦
		
		//객체를 통해 필드에 접근하는 방법
		//변수명.필드명;
		//필드에 들어있던 값을 수정할 수 있다.
		c.price = 10000000;
		c.color = "white";
		c.brand = "HYNDAI";
		//c.tire = "금호"; 정의되지 않은 필드를 사용할 수는 없다.
		
		System.out.println("가격 : " + c.price);
		System.out.println("색상 : " + c.color);
		System.out.println("브랜드 : " + c.brand);
		
		//두번째 자동차 객체 만들기
		Car c2 = new Car();
		c2.price = 9000000;
		c2.color = "black";
		c2.brand = "KIA";
		
		System.out.println("가격 : " + c2.price);
		System.out.println("색상 : " + c2.color);
		System.out.println("브랜드 : " + c2.brand);
		
		Car c3 = new Car();
		System.out.println("가격 : " + c3.price);
		System.out.println("색상 : " + c3.color);
		System.out.println("브랜드 : " + c3.brand);
		
		System.out.println(c3);
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
