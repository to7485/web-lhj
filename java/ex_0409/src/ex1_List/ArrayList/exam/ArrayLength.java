package ex1_List.ArrayList.exam;

import java.util.ArrayList;
import java.util.List;

public class ArrayLength {
	public static void main(String[] args) {
		//문자열 타입 리스트 객체를 만든다.
		//리스트에 "Java","Spring","HTML","CSS"를 저장하기
		//각 문자열의 길이를 계산하여 lengths라는 새로운 리스트를
		//만들어서 저장하기
		//lengths 리스트를 출력하기
		
		List<String> sList = new ArrayList<String>();
		List<Integer> lList = new ArrayList<Integer>();
		sList.add("Java");
		sList.add("Spring");
		sList.add("HTML");
		sList.add("CSS");
		
		for(String s : sList) {
			lList.add(s.length());
		}
		
		System.out.println(lList);
		
		//문자열 형태의 리스트 생성하기
		//"김철수","이영희","김철수","박민수","김철수" 저장하기
		//리스트에서 "김철수"가 몇번 들어있는지 계산하여 출력하세요
		
		List<String> names = new ArrayList<>();
		
		names.add("김철수");
		names.add("이영희");
		names.add("김철수");
		names.add("박민수");
		names.add("김철수");
		
		int count = 0;
		
		for(String s : names) {
			if(s.equals("김철수")) {
				count++;
			}
		}
		
		System.out.println("몇 번 : " + count);
		
		//scores라는 이름의 정수타입 리스트를 만든다.
		//88,72,95,60,81을 저장한다.
		//최고점수와 최소점수를 찾아서 차이를 출력하세요
		
		List<Integer> scores = new ArrayList<Integer>();
		scores.add(88);
		scores.add(72);
		scores.add(95);
		scores.add(60);
		scores.add(81);
		
		int max = scores.get(0);
		int min = scores.get(0);
		
		
		for(int i = 0; i < scores.size(); i++) {
			int score = scores.get(i);
			
			if(score > max) {
				max = score;
			}
			
			if(score < min) {
				min = score;
			}
		}
		
		int diff = max - min;
		
		System.out.println("최고 점수 : " + max);
		System.out.println("최저 점수 : " + min);
		System.out.println("점수 차이 : " + diff);
		
		
		
		
		
		
	}
}
