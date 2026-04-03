package ex2_object;

public class ToStringExample {
	public static void main(String[] args) {
		Object obj = new Object();
		
		obj.toString();
		
		SmartPhone myPhone = new SmartPhone("삼성전자","안드로이드");
		
		System.out.println(myPhone);
	}
}
