package ex2_method;

import java.util.Scanner;

public class TimesTableMain {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단 입력 : ");
		
		//클래스에 속했는 메서드를 호출하는 방법
		
		//1. 클래스의 객체를 생성한다.
		TimesTable t = new TimesTable();
		
		//2. 객체를 통해서 메서드를 호출한다.
		//2-1. return을 통해 반환값을 받는경우 연산결과를 변수에 대입한다.
		//2-2. 반환값이 없는경우 호출만 한다.
		t.showTable(sc.nextInt());
		
		
		
		
		
		
		
		
	}
}
