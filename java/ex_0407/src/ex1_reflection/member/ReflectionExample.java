package ex1_reflection.member;

import java.lang.reflect.Constructor;

public class ReflectionExample {
	public static void main(String[] args) {
		Class clazz = Car.class;
		
		//getDeclaredConstructors() : 생성자 정보 읽기
		//Constructor : 클래스의 생성자 정보를 담고 있는 클래스
		System.out.println("[생성자 정보]");
		Constructor[] constructors =
				clazz.getDeclaredConstructors();
		
		//c.getParameterTypes() : 매개변수의 타입을 반환
		for( Constructor c : constructors) {
			System.out.print(c.getName()+"(");
			Class[] parameters = c.getParameterTypes();
			printParamters(parameters);
			System.out.println(")");
		}	
	}

	private static void printParamters(Class[] parameters) {
		for(int i = 0; i < parameters.length; i++) {
			System.out.print(parameters[i].getName());
			if(i < (parameters.length-1)) {
				System.out.print(",");
			}
		}
	}
}




