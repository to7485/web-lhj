package ex2_charstream.exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Scanner;

public class UserMain {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		File f = new File("users.txt");

		while (true) {
			System.out.println("1. 회원가입 | 2. 로그인 | 3. 종료");
			System.out.print("선택 : ");
			int choice = Integer.parseInt(sc.next());

			if (choice == 1) {
				// 회원가입 로직
				System.out.print("아이디 : ");
				String id = sc.next();
				
				System.out.print("비밀번호 : ");
				String password = sc.next();

				User newUser = new User(id, password);
				FileOutputStream fos = new FileOutputStream(f, true);
				fos.write(newUser.toByteData());
				fos.close();
				System.out.println("회원 가입 완료");
			} else if (choice == 2) {
				System.out.print("아이디 : ");
				String id = sc.next();
				
				System.out.print("비밀번호 : ");
				String password = sc.next();

				if (!f.exists()) {
					System.out.println("가입된 회원이 없습니다.");
					continue;
				}

				// 파일 전체 읽기
				FileInputStream fis = new FileInputStream(f);
				byte[] buffer = new byte[(int) f.length()];
				fis.read(buffer);
				fis.close();

				String allUsersData = new String(buffer);
				String[] lines = allUsersData.split("\n");
				boolean loginSuccess = false;

				for (String line : lines) {
					if (line.isEmpty())
						continue;
					String[] parts = line.split(":");
					if (parts[0].equals(id) && parts[1].equals(password)) {
						loginSuccess = true;
						break;
					}
				}

				if (loginSuccess) {
					System.out.println("로그인 성공! 환영합니다.");
				} else {
					System.out.println("로그인 실패: 아이디 또는 비밀번호를 확인하세요");
				}

			} else if (choice == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

		}

	}
}
