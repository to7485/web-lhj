package ex3_interface;

public class CarExample {
	public static void main(String[] args) {
		Car c = new Car();
		c.tire1 = new HankookTire();
		c.tire2 = new HankookTire();
		c.run();
		
		//타이어를 금호타이어로 교체하고 메서드를 실행해보기
		c.tire1 = new KumhoTire();
		c.tire2 = new KumhoTire();
		c.run();
	}
}
