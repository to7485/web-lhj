package ex3_access.method.packge1;

//같은 패키지의 다른 클래스
public class B {
	//메서드를 호출하기 전까지는 실행이 안됨
	public void method() {
		A a = new A();
		
		a.field1 = 1;
		a.field2 = 1;
		//a.filed3 = 1; private이라서 안된다.
		
		a.method1();
		a.method2();
		//a.method3();
	}
	

}
