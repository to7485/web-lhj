package ex2_annotaion.standard;

public class Parent {
	public void method() {};
}

class Child extends Parent{
	
	@Override//부모클래스의 메서드를 재정의한다.
	public void method() {
		// TODO Auto-generated method stub
		super.method();
	}
}
