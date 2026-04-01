package ex2_method;

public class MethodExample {

	//메서드의 구조
	//접근제한자 반환형 메서드명(매개변수){
	//	실행하고자 하는 명령
	//	return 반환값;
	//}
	
	//반환할 값이 없으면 반환형은 void
	//외부에서 받을 값이 없으면 매개변수는 생략 가능하다.
	
	//"메서드가 호출되었습니다"라고 출력되는 printInfo메서드 작성하기
	public void printInfo() {
		System.out.println("메서드가 호출되었습니다.");
	}
	
	//두 수를 더하여 반환하는 add 메서드 작성하기
	public int add(int a, int b) {
		//두 수를 더해서 출력하기
		return a+b;
	}
	
	//원의 넓이를 구하는 circleArea메서드 작성하기
	//원의 넓이 : 3.14 * 반지름 * 반지름
	//반지름을 외부에서 받아서 넓이를 반환하기
	
	//1. 메서드를 정의한다.
	//- 외부에서 받아야 할 값이 있으면 매개변수 설정
	//- 코드블럭에 기능을 정의
	//- 연산 결과를 보내줘야 하면 return을 정의
	public double  circleArea(double r) {
		return 3.14 * r * r;
	}
	
	//원의 둘레를 구하는 circleRound메서드 정의
	//반지름은 외부에서 전달받는다.
	//원의 둘레 : 2 * 3.14 * 반지름
	//메서드 내부에서 둘레를 구하고 출력한다음 종료
	
	public void circleRound(int r) {
		System.out.println(2 * 3.14 * r);
	}
	
	//정수 배열을 매개변수로 받아서 짝수의 개수를 반환하는 countEven 메서드 작성하기
	public int countEven(int[] x) {
		int count = 0;
		for(int i : x) {
			if( i % 2 == 0) {
				count++;
			}
		}
		return count;
	}
	
	//메서드를 만드는 이유
	//자주 사용되는 기능을 재사용하기 위함
	
	//특정 문자 개수 세기
	//문자열과 문자 하나를 매개변수로 받아서
	//문자열에서 해당 문자가 몇번 등장하는지 반환하는 countChar메서드 작성하기
	
	public int countChar(String s, char ch) {
		int count = 0;
		for(String str : s.split("")) {
			if(str.charAt(0) == ch) {
				count++;
			}
		}
		return count;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
