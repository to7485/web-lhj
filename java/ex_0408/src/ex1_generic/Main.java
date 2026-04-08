package ex1_generic;

public class Main {
	public static void main(String[] args) {
		//제네릭에 타입을 넣을 수 있는것은 좋은데
		//아무타입이나 넣어도 된다는것이 문제
		Calculator<Number> cal1 = new Calculator<Number>();
		Calculator<Integer> cal2 = new Calculator<Integer>();
		Calculator<Double> cal3 = new Calculator<Double>();
		Calculator<Long> cal4 = new Calculator<Long>();
		
		//어떤 기능을 만들 때는
		//특정 성질을 가진 타입만 받아야 안전하다는 문제가 생긴다.
		
		//제네릭에 넣을 수 있는 타입의 범위를 한정
		
		//1. 잘못된 타입을 미리 막을 수 있다.
		//2. 상위 타입의 기능을 사용할 수 있다.
		
		
		DeviceManager<Tv> tvManager = new DeviceManager<Tv>(new Tv());
		DeviceManager<Audio> audioManager = new DeviceManager<Audio>(new Audio());
		
		tvManager.powerOn();
		audioManager.powerOn();
		
		//Readable과 Closeable을 동시에 구현한 클래스만이 타입 할당이 가능하다.
		Box<BoxType>box = new Box<>(); 
		
		//ox<Object> box2 = new Box<>();
		
		
		
		
		
		
		
		
		
			
	}
}
