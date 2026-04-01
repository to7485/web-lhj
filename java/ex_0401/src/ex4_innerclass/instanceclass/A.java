package ex4_innerclass.instanceclass;

public class A {
	
	//인스턴스 멤버 클래스
	//일반 클래스와 마찬가지로 필드, 생성자, 메서드를 선언할 수 있다.
	//외부클래스의 멤버를 사용할 목적으로 만든다.
	class B{
		int field1 = 1;
		
		static int field2 = 2;
		
		B(){
			System.out.println("B- 생성자 실행");
		}
		
		void method1() {
			System.out.println("B-method1 실행");
		}
		
		static void method2() {
			System.out.println("B-method2 실행");
		}
	}
	
	B useB() {
		B b = new B(); //내부클래스의 객체 생성
		return b;
	}
	
	
	
	
	
	
	

}
