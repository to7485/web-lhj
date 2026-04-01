package ex5_polymorphism.exam02;

public class DriverExample {
	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.drive(new Vehicle());
		driver.drive(new Bus());
		driver.drive(new Taxi());
	}
}
