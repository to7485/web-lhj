package exam;

import java.util.Scanner;

//빙고 게임 프로세스
//게임의 시작, 빙고 숫자 입력
public class BingoGame {

	//Bingo 객체를 필드로 선언하세요
	//사용자에게 입력을 받기 위한 Scanner 객체를 필드로 선언하세요
	private Bingo board;
	private Scanner sc;
	
	//생성자에서 Bingo 객체를 생성하세요
	//Scanner객체도 생성하세요
	public BingoGame() {
		board = new Bingo();
		sc = new Scanner(System.in);
	}
	
	//start()메서드를 작성하여 게임 전체 흐름을 구현하세요
		
	//반복문을 사용하여 숫자를 계속 입력받을 수 있도록 합니다.
	
	public void start() {
		while(true) {
			//게임 시작시 "빙고 게임을 시작합니다"라고 출력하기
			System.out.println("빙고 게임을 시작합니다");
			
			//1단계
			//현재 빙고판을 출력합니다.
			board.printBoard(); //현재 빙고판 출력
			
			//1-1단계
			//현재 빙고 개수를 계산하여 출력하세요
			//현재 빙고 개수 : X
			int bingoCount = board.countBingo();
			System.out.println("현재 빙고 개수 : " + bingoCount);
			
			//1-2단계
			//빙고 개수가 3개 이상이면 게임을 종료하시오
			//"3빙고 완성! 게임 종료"
			if(bingoCount >= 3) {
				System.out.println("3빙고 완성! 게임종료");
				break;
			}
			
			//2단계
			//사용자에게 숫자를 입력받습니다.
			System.out.print("숫자를 입력하세요 : ");
			int number = sc.nextInt();
			
			boolean result = board.markNumber(number);
			
			//3단계
			//입력한 숫자가 빙고판에 존재하면 체크처리
			//4단계
			//숫자가 존재한다면 "X를 체크했습니다." 라고 출력하기
			if(result) {
				System.out.println(number+"를 체크했습니다.");
			} else {
				//5단계
				//숫자가 빙고판에 없으면 "빙고판에 없는 숫자입니다."라고 출력하기
				System.out.println("빙고판에 없는 숫자입니다.");
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
}






