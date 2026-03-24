package ex1_operator;

public class TernaryOperatorExample {
	public static void main(String[] args) {
		//삼항연산자
		// 조건식 ? 값1 : 값2;
		//조건식 : 참,거짓을 판별할 수 있는 식
		
		int x = 10;
		String result = x > 5 ? "크다" : "작다";
		System.out.println(result);
		
		int a = 10;
		int b = 15;
		boolean result2 = ++a >= b ? true : false;
		
		//정수, 문자형 또한 가능하다.
		
		//삼항연산자의 중첩이 가능하다.
		int score = 85;
		char grade = (score > 90) ? 'A' : (score > 80) ? 'B' : 'C';
		System.out.println("성적 : " + grade);
		
		
		
		
		
		
		
		
		
		
		
	}
}
