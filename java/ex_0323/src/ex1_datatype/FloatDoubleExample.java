package ex1_datatype;

public class FloatDoubleExample {
	public static void main(String[] args) {
		//리터럴 : 변수에 저장하기 위한 값 자체
		
		//실수 리터럴 값은 기본타입으로 double로 취급한다.
		//숫자 뒤에 f를 붙여 해당 값이 float타입이라는것을 명시해야한다. 
		
		//정밀도
		float f1 = 0.1234567890123456789f;
		double d1 = 0.1234567890123456789;
		
		System.out.println("float : " + f1);
		
		//double타입은 정밀한 작업을 할 때 유용하다.
		System.out.println("double : " + d1);
		
		//10의 거듭제곱 리터럴
		double d2 = 3e6;// -> 3 x 10^6
		float f2 = 3e6F;// -> 3 x 10^6;
		double d3 = 2e-3; // -> 2 x 10^-3;
		
		System.out.println("d2 : " + d2);
		System.out.println("f2 : " + f2);
		System.out.println("d3 : " + d3);
		
		
		
		
		
		
		
	}
}
