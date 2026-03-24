package ex2_if;

import java.util.Scanner;

public class IfExample {
	public static void main(String[] args) {
		int score = 93;
		
		if(score >= 90) {
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A입니다.");
		}
		
		if(score <= 90) {
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B입니다.");
		}
		
		//정수 하나를 입력받아서 짝수면 "짝수", 홀수면 "홀수"를
		//출력하는 코드 작성하기
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		if(num % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		
		if(num % 2 != 0) {
			System.out.println("홀수");
		}
		
		
		
		
		
		
		
		
	}
}
