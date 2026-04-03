package app;

import pack1.A; //my_module_a에서 가져옴
//import pack2.B; //my_module_a에서 가져옴
import pack3.C; //my_module_b에서 가져옴

public class Main {
	public static void main(String[] args) {
		A a = new A();
		a.method();
		
//		B b = new B();
//		b.method();
		
		C c = new C();
		c.method();
		
		C result = a.getC();
		result.method();
		
		
		
		
		
	}
}
