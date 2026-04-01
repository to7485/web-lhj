package ex1_abstract;

public class Bus extends Transport {

	//상속을 받으면 자식객체가 만들어질 때
	//부모생성자가 먼저 호출이 된다.
	//super()가 생략이 되어있는데
	//부모생성자에 매개변수가 들어있으면
	//명시해줘야 한다.
	public Bus(String name, int baseFare) {
		super(name,baseFare);
	}
	
	@Override
	int calculateFare() {
		return baseFare; //기본요금만 내면됨
	}
}
