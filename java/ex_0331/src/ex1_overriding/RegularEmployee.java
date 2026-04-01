package ex1_overriding;

public class RegularEmployee extends Employee{
	int salary;
	
	public RegularEmployee(String name, int salary) {
		super(name);
		this.salary = salary;
	}
	
	@Override
	public int getPay() {
		return salary;
	}

}
