package ex1_datatype;

public class BooleanExample {
	public static void main(String[] args) {
		boolean b1 = true;
		boolean b2 = false;
		
		System.out.println(b1);
		System.out.println(b2);
		
		//변수의 이름을 잘 지어야 한다.
		boolean isOn = true; //전등이 켜져있는 상태이다.
		boolean isStudent = false; //학생이 아니다.
		
		//boolean 변수를 다른 변수에 대입할 수 있다.
		boolean copy = isOn;
		System.out.println("복사한 값 : " + copy);
		
		//boolean은 true/false값만 올 수 있다.
		isOn = false;
		System.out.println("전등 상태 바뀜 : " + isOn);
		
		
		
		
		
		
		
		
	}
}
