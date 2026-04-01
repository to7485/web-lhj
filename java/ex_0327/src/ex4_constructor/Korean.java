package ex4_constructor;

public class Korean {

	//필드
	String nation = "대한민국";
	String name;
	String ssn;
	
	//생성자 선언
	//클래스의 필드와 메서드의 매개변수의 이름이 겹칠 때
	//메서드 내부에서는 매개변수의 우선순위가 더 높다.
	//필드와 지역변수를 구분하기 위하여 this키워드를 사용한다.
	
	//this : 이 메서드를 호출한 객체 자신을 의미한다.
	public Korean(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
	}
	
	//객체의 정보를 출력하는 printInfo 메서드 만들기
	public void printInfo() {
		System.out.println("국적 : " + this.nation);
		System.out.println("이름 : " + this.name);
		System.out.println("주민번호 : " + this.ssn);
	}
}








