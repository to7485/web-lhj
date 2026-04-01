package ex1_abstract;

public abstract class Transport {

	String name;//운송수단 이름
	int baseFare; //기본요금
	
	//생성자를 통해서 필드의 내용을 전달받는다.
	public Transport(String name, int baseFare) {
		this.name = name;
		this.baseFare = baseFare;
	}
	
	public void showName() {
		System.out.println("교통수단 : " + name);
	}
	
	//총 요금 계산
	abstract int calculateFare();
	
	public void printFare() {
		showName();
		System.out.println("기본요금 : " + baseFare);
		System.out.println("총 요금 : " + calculateFare()+"원");
	}
	
	
	
	
	
	
}
