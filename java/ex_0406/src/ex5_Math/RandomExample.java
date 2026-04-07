package ex5_Math;

import java.util.Arrays;
import java.util.Scanner;

public class RandomExample {
	public static void main(String[] args) {
		//로또번호(1 ~ 45)를 뽑아서 배열에 넣는다.
		int[] lotto = new int[6];
		
		for(int i = 0; i < lotto.length; i++) {
			lotto[i] = (int)(Math.random() * 45) + 1;
			
			//중복체크
			for(int j = 0; j <i; j++) {
				if(lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}
		
		
		//키보드에서 6개의 숫자를 입력받아서 번호 맞추기
		Scanner sc = new Scanner(System.in);
		int[] user = new int[6];
		System.out.println("로또번호 6개 입력(1~45)");
		for(int i = 0; i < user.length; i++) {
			user[i] = sc.nextInt();
		}
		
		//각 배열을 정렬한 뒤 Arrays.equals() 활용하기
		Arrays.sort(lotto);
		Arrays.sort(user);
		
		System.out.println("로또 번호 : " + Arrays.toString(lotto));
		System.out.println("내 번호 : " + Arrays.toString(user));
		
		if(Arrays.equals(lotto,user)) {
			System.out.println("1등 당첨");
		} else {
			System.out.println("꽝");
		}
		
		
		
		
		
		
	}
}
