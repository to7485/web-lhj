package ex5_operator;

public class CompareOperatorExample {
	public static void main(String[] args) {
		//관계(비교)연산자
		//크기비교(<,<=,>,>=)
		//동등비교(==, !=)
		
		//비교연산자는 흐름 제어문인 조건문(if), 반복문에서
		//실행의 흐름을 제어할 때 주로 사용
		
		int num1 = 10;
		int num2 = 10;
		//비교연산자의 결과는 항상 논리형으로 반환이 된다.
		
		boolean result1 = num1 == num2;
		
		System.out.println("result1 : " + result1);
		
		//같지 않으면 true, 같으면 false
		boolean result2 = num1 != num2;
		System.out.println("result2 : " + result2);
		
		boolean result3 = (num1 <= num2);
		System.out.println("result3 : " + result3);
		
		char char1 = 'A';
		char char2 = 'B';
		
		boolean result4 = (char1 < char2);
		System.out.println("result4 : " + result4);
		
		//문자열 끼리의 비교
		String str1 = "자바";
		String str2 = "Java";
		String str3 = new String("자바");
		//참조자료형의 변수는 ==으로 비교하면 주소값을 비교한다.
		boolean result5 = str1 == str3;
		System.out.println("result5 : " + result5);
		
		//문자열의 내용물 비교
		//equals() 메서드를 사용
		//변수.equals(비교하려는 변수);
		boolean result6 = str1.equals(str3);
		System.out.println("result6 : " + result6);
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
