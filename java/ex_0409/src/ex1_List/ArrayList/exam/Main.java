package ex1_List.ArrayList.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		//3명의 아이디와 비밀번호를 입력하여 list에 저장
		//아이디가 중복되면 추가하지 않고 다시 입력받기
		Scanner sc = new Scanner(System.in);
		List<UserInfo> list = new ArrayList<>();
		
		outer:for(int i = 0; i <3; i++) {
			UserInfo user = new UserInfo();
			System.out.print("아이디 : ");
			user.setId(sc.next());
			
			//아이디 입력받고 list에 겹치는게 있는지 확인
			for(int j = 0; j < i; j++) {
				if(user.getId().equals(list.get(j).getId())) {
					System.out.println("아이디가 중복됩니다.");
					i--;
					continue outer;
				}
			}
			
			System.out.print("비밀번호 : ");
			user.setPassword(sc.nextInt());
			list.add(user);
			
			for(UserInfo u : list) {
				System.out.println(u.getId());
				System.out.println(u.getPassword());
				System.out.println("---------");
			}
		}	
	}
}
