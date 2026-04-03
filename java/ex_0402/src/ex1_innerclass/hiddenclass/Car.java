package ex1_innerclass.hiddenclass;

public class Car {

	private Tire tire1 = new Tire();
	
	private Tire tire2 = new Tire() {
		//익명클래스
		@Override
		public void roll() {
			System.out.println("오버라이딩 타이어가 굴러갑니다.");
		};
	};
	//1. 필드를 이용
	public void run1() {
		tire1.roll();
		tire2.roll();
	}
	
	//지역변수를 이용
	public void run2() {
		Tire tire = new Tire() {
			public void roll() {
				System.out.println("지역변수 타이어가 굴러갑니다.");
			};
		};
		tire.roll();
	}
	
	//3.매개변수로 이용
	public void run3(Tire tire) {
		tire.roll();
	}
	
	
}





