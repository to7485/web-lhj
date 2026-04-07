package ex1_reflection.member;

public class Car {
	//필드
	//모두 private
	//String model
	//String owner
	private String model;
	private String owner;
	
	//기본생성자
	public Car() {
	}
	
	//모델만 초기화하는 생성자
	public Car(String model) {
		this.model = model;
	}

	//setter & getter
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
}





