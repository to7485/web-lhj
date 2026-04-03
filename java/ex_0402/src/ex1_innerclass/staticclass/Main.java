package ex1_innerclass.staticclass;

public class Main {
	public static void main(String[] args) {
		
		//정적 내부클래스의 객체 생성방법
		Outer.Inner inner = new Outer.Inner();
		
		User user = new User.Builder()
				.id("hong")
				.password("1234")
				.name("홍길동")
				.age(20)
				.build();
		
		
		
		
		
		
		
		//단점
		//매개변수가 많아서 순서를 헷갈리기 쉽다.
		//어떤값이 필수인지 한눈에 안보인다.
		//생성자가 너무 많이 오버로딩 될 수 있다.
		
		
		
		
		
		
		
		
		
		
		
	}
}
