package ex4_constructor;

public class PersonMain {
	public static void main(String[] args) {
		//Person p2 = new Person();
		
		//매개변수가 정의되어 있으면
		//호출할 때 반드시 값을 전달해야 한다.
		Person p = new Person("홍길동",30);
		p.introduce();
		p.age = 50;
		Person p2 = new Person("김길동", 40);
		
		
		
		
		
		
		
		
		
	}
}
