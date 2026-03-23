package ex2_casting;

public class PromotionExample {
	public static void main(String[] args) {
		//자동 타입 변환
		//작은 자료형 -> 큰자료형으로 바꾸려고 할 때
		//자동으로 변환이 된다.
		
		byte byteValue = 10;
		int intValue = byteValue;
		System.out.println("intValue : " + intValue);
		
		intValue = 50;
		long longValue = intValue;
		System.out.println("longValue : " + longValue);
		
		//문자형타입의 자동형변환
		//문자형 -> 정수형타입
		char c = 'A';
		int num = c; //문자형타입 데이터를 정수형 변수에 대입
		System.out.println(num); //아스키코드값으로 변경되서 나온다.
		
		
		
		
	}
}
