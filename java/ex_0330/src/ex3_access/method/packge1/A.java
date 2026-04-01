package ex3_access.method.packge1;

public class A {

	public int field1;
	
	int field2;
	
	private int field3;
	
	public void method1() {
		
	}
	
	void method2() {
		
	}
	
	private void method3() {
		
	}
	
	public A() {
		//현재 클래스내부에서 모든 접근제한자의 필드나 메서드를 사용할 수 있다.
		field1 = 1;
		field2 = 1;
		field3 = 1;
		
		method1();
		method2();
		method3();
	}
	
	
	
	
	
	
	
}
