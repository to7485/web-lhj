package test;

//public : 프로젝트 내부 어디에서든지 호출 가능
//private : 현재 클래스에서만 사용 가능
//default : 같은 패키지에서만 사용 가능

//클래스
public class Person {
	//필드는 거의 private으로 지정한다.
	private String name;
	private int age;
	
	public Person() {
		
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
}







