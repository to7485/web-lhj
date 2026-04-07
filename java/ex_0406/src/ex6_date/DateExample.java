package ex6_date;

import java.util.Date;

public class DateExample {
	public static void main(String[] args) {
		//Date클래스
		//날짜 + 시간을 하나의 객체로 표현
		//1970년 1월 1일 기준
		//대부분 메서드가 deprecated
		Date now = new Date();
		System.out.println(now);
	}
}
