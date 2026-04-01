package ex4_constructor;

public class Person {

	//필드
	String name;
	int age;
	
	//생성자(정의)
	//매개변수와 클래스의 멤버변수와 이름이 같다면
	//매개변수의 사용 우선순위가 더 높다.
	//생성자(or메서드)를 호출한 객체의 필드임을 명시하기 위해서
	//this키워드를 사용한다.
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//메서드(정의)
	public void introduce() {
		System.out.printf("안녕하세요. 저는 %d살 %s입니다.",age,name);
	}
}
