package ex2_while;

import java.util.Scanner;

public class DoWhileExample {
	public static void main(String[] args) {
		System.out.println("메시지를 입력하세요");
		System.out.println("프로그램을 종료하려면 q를 입력하세요");
		
		Scanner sc = new Scanner(System.in);
		
		String inputString;
		
//		do {
//			System.out.print(">");
//			inputString = sc.nextLine();
//			System.out.println(inputString);
//		}while(!inputString.equals("q"));
		
		//--------------------------------------------------
		//사용자가 비밀번호를 입력한다.
		//비밀번호가 "1234"와 같을때까지 계속 입력받는다.
		//단, 5번 틀리면 "접속 차단"출력 후 종료
		//성공하면 "로그인 성공" 출력하기
		
		String password;
		int count = 0;
		
		do {
			System.out.print("비밀번호 입력 : ");
			password = sc.nextLine();
			count++;
			
			//내가 입력한 비밀번호와 "1234"가 일치하는지 확인
			if(password.equals("1234")) {
				System.out.println("로그인 성공");
			} else if(count == 5) {
				System.out.println("접속 차단");
			}
		}while(!password.equals("1234") && count < 5);
		
		//정수를 입력받는다.
		//입력받은 수를 뒤집어서 출력하세요
		//1234
		//4321
		
		int original;
		int reverse = 0;
		
		System.out.print("정수 입력 : ");
		original = sc.nextInt();
		
		do {
			reverse = reverse * 10 + original % 10;
			
			original /= 10;
			
		}while(original != 0);
		
		System.out.println("뒤집은 수 : " + reverse);
		
		
		
		
		
		
		
		
		
		
		
	}
}
