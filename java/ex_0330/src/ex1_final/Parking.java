package ex1_final;

public class Parking {
	//기본요금 : 10,000원(상수)
	static final int BASE_FEE = 10000;
	//추가 요금 : 시간당 2,000(상수)
	static final int EXTRA_FEE = 2000; 
	
	//요금계산 메서드
	public static int calculateFee(int time) {
		return BASE_FEE + (time * EXTRA_FEE);
	}
	
}
