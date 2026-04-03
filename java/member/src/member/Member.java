package member;

//자바에서 앞글자가 대문자로 시작하는것
//클래스명, 인터페이스명, 열거형

//내가 회원관리 프로그램에서 "회원"의 정의
public class Member {

	private String name;
	private int age;
	
	//생성자
	//접근제한자 클래스명(매개변수){
	//
	//}
	
	//필드에 값을 넣어주는 방법
	//1. 필드에 직접 넣는다.(private일경우 불가능)
	//2. 생성자를 통해서 초기화 한다.
	//3. setter를 통해서 대입한다.
	
	//this : 해당 메서드를 호출한 객체의 정보
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//setter & getter
	//한번에 한가지 필드만 세팅하거나 반환
	//set필드명, get필드명
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	
	
	
	
	
	
	
	
	
	
}
