package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

//빙고판의 생성, 출력, 빙고 개수 세기
public class Bingo {

	private int[][] board; // 빙고판

	public Bingo() {
		createBoard();
	}

	private void createBoard() {
		// 1 ~ 50사이의 난수가 있다.
		// 5 X 5의 빙고판에 25개의 숫자를 채운다.
		// 겹치면 안됨!

		// 만약 숫자가 오름차순으로 연속되게 나오면 섞어주기

		// ex)

		// 5 7 23 9 13
		// 41 38 17 10 3
		// 26 ...
		//

		HashSet<Integer> set = new HashSet<Integer>();
		board = new int[5][5];

		while (set.size() != 25) {
			set.add((int) (Math.random() * 50) + 1);
		}

		List<Integer> list = new ArrayList<Integer>(set);

		Collections.shuffle(list);

		Iterator<Integer> iter = list.iterator();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = iter.next();
				System.out.printf("%02d ", board[i][j]);
			}
			System.out.println();
		}
	}

	// 숫자를 체크하는 메서드
	// 매개변수 : int number
	// 메서드명 : markNumber
	// 숫자를 넘겨받으면 해당 빙고판의 숫자를 0으로 바꾸고 true를 반환
	// 아니면 false를 반환
	public boolean markNumber(int number) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == number) {
					board[i][j] = 0;
					return true;
				}
			}
		}
		return false;
	}

	// 현재 빙고판의 상태를 출력하는 printBoard() 메서드 만들기
	// 체크된 칸의 숫자는 X로 출력해주세요
	//	08 14 25 37 42
	//	11 03 50 29 16
	//	 X  22 18 09 31
	//	44 10 27 35 01
	//	13 06 40 19 47
	
	public void printBoard() {
		System.out.println("==== 현재 빙고판 ===");
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == 0) {
					System.out.print(" X ");
				} else {
					System.out.printf("%02d ",board[i][j]);
				}
			}
			System.out.println();
		}
	}
	
	//빙고 개수 계산 기능
	//현재 빙고판에서 완성된 빙고 줄 수 를 계산하는 countBingo()메서드 작성하기
	//빙고는 다음 기준으로 판단하시오
	//가로 5줄, 세로 5줄, 대각선 2줄
	//총 빙고 개수를 int로 반환하세요
	public int countBingo() {
		//빙고 개수를 세기 위한 변수
		int bingoCount = 0;
		boolean bingo = false;
		//가로 검사
		for(int i = 0; i < board.length; i++) {
			bingo = true;
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] != 0) {
					bingo = false;
					break;
				}
			}
			if(bingo) {
				bingoCount++;
			}
		}
		
		//세로 검사
		for(int i = 0; i < board.length; i++) {
			bingo = true;
			for(int j = 0; j < board[i].length; j++) {
				if(board[j][i] != 0) {
					bingo = false;
					break;
				}
			}
			if(bingo) {
				bingoCount++;
			}
		}
		
		//왼쪽위 -> 오른쪽 아래
		for(int i = 0; i < board.length; i++) {
			bingo = true;
			if(board[i][i] !=0) {
				bingo = false;
				break;
			}
		}
		if(bingo) {
			bingoCount++;
		}
		
		//오른쪽위 -> 왼쪽 아래
		for(int i = 0; i < board.length; i++) {
			bingo = true;
			if(board[i][4-i] != 0) {
				bingo = false;
				break;
			}
		}
		
		if(bingo) {
			bingoCount++;
		}
		
		
		
		return bingoCount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
