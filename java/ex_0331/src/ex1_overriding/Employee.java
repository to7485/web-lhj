package ex1_overriding;

public class Employee {

	String name;
	
	public Employee(String name) {
		this.name = name;
	}
	
	public int getPay() {
		return 0;
	}
}
