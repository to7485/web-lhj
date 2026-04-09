package ex1_List.ArrayList.product;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Cart cart = new Cart();

		while (true) {
			System.out.println("\n===== 장바구니 메뉴 =====");
			System.out.println("1. 상품 추가");
			System.out.println("2. 장바구니 보기");
			System.out.println("3. 총 금액 보기");
			System.out.println("4. 상품 삭제");
			System.out.println("0. 종료");
			System.out.print("선택 >> ");

			int choice = sc.nextInt();
			sc.nextLine(); // 버퍼 제거
			
			if(choice == 1) {
				System.out.print("상품명 : ");
				String name= sc.nextLine();
				
				System.out.print("가격 : ");
				int price = sc.nextInt();
				
				System.out.print("수량 : ");
				int quantity = sc.nextInt();
				
				cart.addProduct(name, price, quantity);
				
			} else if(choice == 0) {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
}




