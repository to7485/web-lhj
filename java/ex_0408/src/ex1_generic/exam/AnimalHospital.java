package ex1_generic.exam;

public class AnimalHospital<T extends Animal> {
	private T animal;
	
	public AnimalHospital(T animal) {
		this.animal = animal;
	}
	
	public void treat() {
		animal.move();
	}

}
