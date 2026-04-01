package ex2_interface;

public class CastingExample {
	public static void main(String[] args) {
		//자동타입변환
		Vehicle vehicle = new Bus();
		
		vehicle.run();
		//vehicle.checkFare();
		
		//강제 타입 변환후 호출
		((Bus)vehicle).checkFare();
		
		
	}
}
