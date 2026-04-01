package ex1_abstract;

public class Main {
	public static void main(String[] args) {
		
		//추상클래스의 객체는 직접만들 수 없다.
		//Animal a = new Animal();
		
		Tiger t = new Tiger();
		t.name = "호랑이";
		t.eat();
		t.sound();
		
		Lion l = new Lion();
		l.name = "사자";
		l.eat();
		l.sound();
		
		Delivery [] d = {new RoketDelivery(), new StorePickup()};
		
		for(Delivery delivery : d) {
			delivery.printInvoice();
			delivery.ship();
			delivery.complete();
			System.out.println("-------------");
		}
		
		Transport[] transport = {
				new Bus("버스", 1200),
				new Taxi("택시", 4000, 10, 100),
				new AirPlane("비행기",100000, 50000,200000)
		};
		
		for(Transport t2 : transport) {
			t2.printFare();
			System.out.println("--------");
		}
		
		
		
		
		
		
		
		
	}
}
