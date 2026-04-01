package ex1_final;

public class Korean {

	//final 필드를 선언하는 두가지 방법
	
	//1. 선언과 동시에 값을 초기화한다.
	final String nation = "대한민국";
	
	//2. 생성자를 호출하면서 매개변수로 값을 넘겨준다.
	final String ssn;
	
	String name;
	
	
	
	public Korean(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}
	
	
	
	
	
	
	
	
	
}
