package ex5_singleton;

public class Singleton {

	//클래스 내부에서 객체를 생성함
	private static Singleton singleton = new Singleton();
	
	String s = "홍길동";
	
	//private 접근 제한을 갖는 생성자를 정의
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
	
	
	
	
	
	
}
