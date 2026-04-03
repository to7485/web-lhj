package ex1_innerclass.hiddenclass;

public class Main {
	public static void main(String[] args) {
		Car c = new Car();
		
		//익명 자식 객체가 대입된 필드의 사용
		c.run1();
		
		//익명 자식 객체가 대입된 로컬변수 사용
		c.run2();
		
		c.run3(new Tire() {
			@Override
			public void roll() {
				System.out.println("익명 자식 Tire 객체3이 굴러갑니다.");
			}
		});
		
		
		Home h = new Home();
		
		h.use1();
		
		h.use2();
		
		//매개변수로 익명클래스 객체를 만들어서
		//"난방을 켭니다"
		//"난방을 끕니다"
		h.use3(new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("난방을 켭니다.");
			}
			
			@Override
			public void turnOff() {
				System.out.println("난방을 끕니다.");
				
			}
		});
		
		//익명클래스는 인터페이스에서 많이 활용된다.
		
		Calculator calc = new Calculator() {
			
			//접근제한자를 부모보다 좁게 줄일 수 없다
			@Override
			public void add(int x, int y) {
				System.out.println("결과 : " + (x+y));
			}
		};
		
		calc.add(1, 2);
		
	}
}




