package ex3_protected.package1;

public class B {

	public void method() {
		//B클래스는 A클래스와 동일한 패키지에 있기 때문에
		//protected로 선언된 필드, 생성자, 메서드에 접근이 가능하다.
		A a = new A();
		a.field = "value";
		a.method();
	}
}
