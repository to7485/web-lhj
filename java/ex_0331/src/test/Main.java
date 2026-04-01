package test;

//자바에서는 웬만한 작업을 메서드 안에서 진행한다.
public class Main {
	public static void main(String[] args) {
		Person p = new Person();
		
		//필드에 값을 초기화 하는 방법 3가지
		
		//1. 필드에 직접 값 넣기
		//p.name = "홍길동";
		//p.age = 30;
		
		//2. 생성자를 통해 초기화 하기
		Person p2 = new Person("박길동",40);
		
		//3. setter&getter (메서드를 통해 초기화 하기)
		Person p3 = new Person();
		
		p3.setName("김길동");
		p3.setAge(20);
		
		System.out.println(p3.getName());
		System.out.println(p3.getAge());
		
		
		
		
		
		
		
		
	}
}







