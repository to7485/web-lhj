package ex1_List.ArrayList.exam;

import java.util.ArrayList;
import java.util.List;

public class ArrayExam {
	public static void main(String[] args) {
		//Integer 타입의 리스트 객체 만들기
		List<Integer> list = new ArrayList<Integer>();
		
		//리스트에 (1~30사이의)난수 10개 넣기
		for(int i = 0; i <10;i++) {
			int randomNumber = (int)(Math.random()*30)+1;
			list.add(randomNumber);
		}
		
		//리스트에 담긴 데이터 중 홀수의 총합을 구하세요
		int total = 0;
//		for(int x : list) {
//			if(x % 2 == 1) {
//				total += x;
//			}
//		}
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) % 2 ==1) {
				total+= list.get(i);
			};
		}
		
		System.out.println(list);
		System.out.println("총 합 : " + total);
		
	}
}
