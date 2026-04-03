package ex1_exception;

import java.util.Scanner;

public class ExceptionExample {
	public static void main(String[] args) {
		
		//NullPointerException
		//참조변수에 null이 들어가 있는데 필드나 메서드를 사용하려고 할 때
		//발생하는 예외
//		int[] array = null;
//		System.out.println(array[0]);
		
		//NumberFormatException
		//잘못된 문자열을 숫자로 형변환 할 때 발생
		
//		String str01 = "11.2";
//		int num01 = Integer.parseInt(str01);
		
		//ArrayIndexOutOfBoundsException
		//배열에서 인덱스 범위를 초과해 사용할 때 발생한다.
		
//		int [] arr = {1,2,3,4,5};
//		System.out.println(arr[6]);
		
		//ArithmeticException
		//정수를 0으로 나누려고 할 때 발생한다.
		//System.out.println(10/0);
		
		//InputMismatchException
		//입력 메서드와 입력한 값의 타입이 맞지 않을 때
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : " );
		int num = sc.nextInt();
		
		
		
		
		
		
		
		
		
		
	}
}
