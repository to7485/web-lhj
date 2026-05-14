package main;

import java.util.Scanner;

import dao.BookDAO;
import dao.CustomerDAO;
import dao.RentalDAO;
import dto.BookDTO;
import dto.CustomerDTO;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		CustomerDAO customerDAO = new CustomerDAO();
		BookDAO bookDAO = new BookDAO();
		RentalDAO rentalDAO = new RentalDAO();
		
		while(true) {
			System.out.println("도서 대여 관리 프로그램");
			System.out.println("1. 고객 등록");
			System.out.println("2. 도서 등록");
			System.out.println("3. 도서 전체 조회");
			System.out.println("4. 도서 대여");
			System.out.println("5. 전체 대여 목록 조회");
			System.out.println("6. 고객별 대여 목록 조회");
			System.out.println("7. 재고 부족 도서 조회");
			System.out.println("0. 종료");
			
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1:
				//고객 정보를 입력받아서 customer테이블에 등록하기
				System.out.print("고객명 : ");
				String name = sc.nextLine();
				
				System.out.print("전화번호 : ");
				String phone = sc.nextLine();
				
				customerDAO.insertCustomer(new CustomerDTO(name,phone));
				break;
				
			case 2:
				//도서 정보(제목,저자,개수)를 입력받아서 book테이블에 저장하기
				System.out.print("도서명 : ");
				String title = sc.nextLine();
				
				System.out.print("저자 : ");
				String author = sc.nextLine();
				
				System.out.print("재고 : ");
				int stock = sc.nextInt();
				
				bookDAO.insertBook(new BookDTO(title,author,stock));
				break;
				
			case 3:
				//도서 전체 조회하기
				bookDAO.findAllBooks();
				break;
			case 4:
				//고객번호와 도서번호를 입력받아 도서 대여하기
				System.out.print("고객 번호 : ");
				int customerId = sc.nextInt();
				
				System.out.print("도서 번호 : ");
				int bookId = sc.nextInt();
				
				rentalDAO.rentalBook(customerId, bookId);
				break;
			case 5:
				//전체 대여 목록
				rentalDAO.findRentalList();
				break;
			case 6:
				//고객별 대여 목록 조회
				//고객 id를 입력받아서 고객명, 제목, 빌린날짜 순으로 출력하기
				System.out.print("고객 번호 : ");
				int searchCustomerId = sc.nextInt();
				
				rentalDAO.findRentalByCustomer(searchCustomerId);
				break;
			case 7:
				//재고부족 도서 조회
				//재고가 2권 이하인 도서를 조회
				bookDAO.findLowStockBooks();
				break;
			case 0:
				//프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
		
		//박민수 010-3333-3333 회원 추가하기
		
		//customerDAO.insertCustomer(new CustomerDTO("박민수","010-3333-3333"));
		//bookDAO.insertBook(new BookDTO("이것이 자바다","신용권",6));
		//bookDAO.findAllBooks();
		//rentalDAO.rentalBook(1, 1);
		
		
		
		
		
		
		
		
		
		
	}
}
