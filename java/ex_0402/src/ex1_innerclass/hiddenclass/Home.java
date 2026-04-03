package ex1_innerclass.hiddenclass;

public class Home {
	//인터페이스의 객체는 직접 만들 수 없다.
	//인터페이스를 구현하는 클래스를 만들어 객체로 사용해야 한다.
	private RemoteControl rc = new RemoteControl() {
		
		@Override
		public void turnOn() {
			System.out.println("tv를 켰습니다.");
		}
		
		@Override
		public void turnOff() {
			System.out.println("티비를 껐습니다.");
		}
	};
	
	public void use1() {
		rc.turnOn();
		rc.turnOff();
	}
	
	public void use2() {
		RemoteControl rc = new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("에어컨을 켭니다.");
				
			}
			
			@Override
			public void turnOff() {
				System.out.println("에어컨을 끕니다.");
				
			}
		};
		
		rc.turnOn();
		rc.turnOff();
	};
	
	public void use3(RemoteControl rc) {
		rc.turnOn();
		rc.turnOff();
	}
	
	
	
	
	
	
	
}
