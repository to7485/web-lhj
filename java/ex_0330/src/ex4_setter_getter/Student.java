package ex4_setter_getter;

//학생의 정보를 담고 있는 클래스
public class Student {

	//필드
	private String name;
	private int age;
	
	//하나에 하나의 필드만 설정
	public void setName(String name) {
			this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		if(age >= 0) {
			this.age = age;
		} else {
			System.out.println("잘못된 나이입니다.");
		}
		
	}
	
	public int getAge() {
		return age;
	}
	
	
	
	
	
	
	
}
