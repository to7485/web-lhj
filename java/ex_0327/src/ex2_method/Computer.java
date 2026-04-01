package ex2_method;

public class Computer {
	
	public int sum(int ... values) {
		int sum = 0;
		
		for(int x : values) {
			sum += x;
		}
		
		//값을 반환하는 경우
		//메서드 내부에서 출력하고 끝내는 경우
		return sum; 
	}
}








