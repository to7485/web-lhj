package ex2_system;

public class TimeExample {
	public static void main(String[] args) {
		//currentTimeMillis()
		//로그시간, 날짜 계산
		//1970년 1월 1일 0시 0분 0초부터 현재까지 흐른 시간을 밀리초 단위로 반환
		long time = System.currentTimeMillis();
		System.out.println(time);
		
		long start = System.currentTimeMillis();
		
		//작업
		for(int i = 0; i < 10000000; i++) {};
		
		long end = System.currentTimeMillis();
		
		System.out.println("걸린시간(ms) : " + (end-start));
		
		System.out.println("-------------");
		
		//nanoTime()
		//정확한 시간을 측정하기 위한 메서드
		//나노초 (1초 = 10억 ns)
		//성능 테스트
		//알고리즘 비교
		
		start = System.nanoTime();
		
		//작업
		for(int i = 0; i < 10000000; i++) {};
		
		end = System.nanoTime();
		
		System.out.println("걸린시간(ns) : " + (end-start));
		
		
		
	}
}
