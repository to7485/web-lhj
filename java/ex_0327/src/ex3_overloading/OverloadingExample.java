package ex3_overloading;

public class OverloadingExample {
	//메서드의 오버로딩
	//메서드의 이름은 동일해야 한다.
	//1. 매개변수의 개수가 달라야 한다.
	//2. 개수가 같다면 타입이 달라야 한다.
	//3. 개수와 타입이 같다면 순서가 달라야 한다.
	
	public int plus(int x, int y) {
		return x + y;
	}
	
	public double plus(double x, double y) {
		return x + y;
	}
	
	public String plus(String x, String y) {
		return x + y;
	}
	
	public int plus (int x) {
		return x * x;
	}
	
	
	
	
	
	
}





