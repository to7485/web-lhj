package ex5_static;

public class CalculatorMain {
	public static void main(String[] args) {
		//정적 필드, 정적 메서드는 객체 생성없이 호출하여 사용할 수 있다.
		//사용방법
		//클래스명.필드명
		//클래스명.메서드명();
		
		System.out.println(Calculator.pi);
		System.out.println(Calculator.plus(3, 4));
		System.out.println(Calculator.minus(24, 4));
		System.out.println("--------------------");
		Calculator c = new Calculator();
		System.out.println(c.pi);
		c.pi = 1.23;
		Calculator c2 = new Calculator();
		System.out.println(c2.pi);
		
		
		
		
		
		
		
	}
}
