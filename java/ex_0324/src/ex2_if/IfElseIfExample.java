package ex2_if;

import java.util.Scanner;

public class IfElseIfExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 : ");
		int score = sc.nextInt();
		//점수가 100 ~90점 "A"
		//89 ~ 80점 "B"
		//79 ~ 70점 "C"
		//69 ~ 60점 "D"
		//59 ~ 0점 "F"
		//0보다 작은수가 들어왔을 때도 "다시 입력해주세요" 출력하기
		if(score > 100 || score < 0) {
			System.out.println("다시 입력해주세요");
		} else if(score >= 90) {
			System.out.println("A");
		} else if(score >= 80) {
			System.out.println("B");
		} else if(score >= 70) {
			System.out.println("C");
		} else if(score >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
		
		
		
		
		
		
		
	}
}
