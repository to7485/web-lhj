package ex6_inheritance;

import ex4_setter_getter.Main;

public class A {

	void hello() {
		System.out.println("A");
	}
	
	public static void main(String[] args) {
		D d = new D();
		d.hello();
	}
}

class B extends A{
	void hello() {
		System.out.println("B");
	}
}

class C extends A{
	void hello() {
		System.out.println("C");
	}
}

class D extends B,C{

}





