package ex2_system;

import java.util.Scanner;

public class SystemFieldExample {
	public static void main(String[] args) {
		//System.out
		//표준 출력 장치
		//콘솔에 메시지를 출력할 때 사용한다.
		System.out.println(System.out);
		
		//System.in
		//표준 입력 장치
		//키보드에서 입력을 받을 때 사용
		System.out.println(System.in);
		
		//System.err
		//표준 에러 출력 장치
		//오류 메시지를 출력할 때 사용
		System.out.println(System.err);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 일반출력은 System.out");
		System.err.println("2. 에러 출력은 System.err");
		
		System.out.print("3. 이름을 입력하세요 : ");
		String name = sc.next();
		
		System.out.print("입력한 이름 : " + name);
		
		
		
		
		
	}
}
