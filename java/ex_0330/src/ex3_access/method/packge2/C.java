package ex3_access.method.packge2;

import ex3_access.method.packge1.A;

//다른 패키지의 다른 클래스
public class C {
	//C의 객체를 만들때 같이 실행이 되는 효과
	public C() {
		A a = new A();
		
		a.field1 = 1;
		a.field2 = 1;
		a.field3 = 1;
		
		a.method1();
		a.method2();
		a.method3();
		
			
	}
}
