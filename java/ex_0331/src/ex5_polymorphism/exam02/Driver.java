package ex5_polymorphism.exam02;

//운전자
public class Driver {

	//매개변수로 부모타입의 변수를 넣는다.
	public void drive(Vehicle vehicle) {
		vehicle.run();
	}
}
