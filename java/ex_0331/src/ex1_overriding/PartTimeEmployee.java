package ex1_overriding;

public class PartTimeEmployee extends Employee{

	int time;
	int pay;
	
	public PartTimeEmployee(String name, int time, int pay) {
		super(name);
		this.time = time;
		this.pay = pay;
	}
	
	@Override
	public int getPay() {
		return time*pay;
	}
	
	
	
	
}
