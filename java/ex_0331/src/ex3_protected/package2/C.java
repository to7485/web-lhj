package ex3_protected.package2;

import ex3_protected.package1.A;

public class C {
	public void method() {
		//C클래스는 A 클래스와 다른 패키지에 있기 때문에
		//A클래스의 protected필드, 생성자, 메서드에 접근할 수 없다.
		A a = new A();
		a.field = "value";
		a.method();
	}
}
