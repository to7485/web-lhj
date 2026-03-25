package ex2_while;

import java.util.Scanner;

public class WhileExample {
	public static void main(String[] args) {
		
		int x = 1;
		
		//x의 값이 변하지 않으면 조건이 거짓이 될 수 없기 때문에
		//무한으로 돌게 된다.
		while(x <4) {
			System.out.println(x);
			x++; //초기식의 값을 변화시켜줄 수 있는 증감식을 따로 작성해줘야 한다.
		}
		
		//1 ~ 6 사이의 난수를 뽑아 변수에 저장하기!
		int rand = (int)(Math.random()*6) + 1;
		
		//정답을 키보드에서 입력받자!
		//정답을 맞출때까지 반복
		
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		
		//몇번만에 정답을 맞출 수 있을지 모름
//		while(answer != rand) {
//			System.out.print("정답 : ");
//			answer = sc.nextInt();
//			if(answer == rand) {
//				System.out.println("정답을 맞췄습니다.");
//			}
//		}
		
		// 1 ~ 100까지의 총 합 구하기 (while문)
		int i = 1;
		
		//결과를 담아줄 변수 만들기
		int total = 0;
		
		while(i <=100) {
			total +=i;
			i++;
		}
		
		System.out.println("1~100까지의 총 합 : " + total);
		
		//키보드에서 정수를 하나 입력받아서, 각 자리의 합을 더한 결과를 출력하세요
		//예를 들어 12345를 입력받았다면 1+2+3+4+5를 더한 15를 출력하기
		
		System.out.println("1/10: " + 1/10);
		
		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();
		int sum = 0; //총 합을 담을 변수
		
		while(num > 0) {
			sum += num % 10;
			num = num /10;
		}
		
		System.out.println("각 자리의 총 합 : " + sum);
		
		
		
	}
}






