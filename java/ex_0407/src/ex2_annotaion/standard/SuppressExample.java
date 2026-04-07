package ex2_annotaion.standard;

//자바 컴파일러가 띄우는 경고 메시지를 일부러 무시하도록 지시하는 어노테이션
@SuppressWarnings({"unchecked","deprecation","unused"})
//경고를 여러개 사용하고 싶으면 초기화 리스트 방식으로 사용
//경고의 종류
//unchecked : 타입 검사가 완전하지 않을 때 발생하는 경고를 숨긴다.
//deprecation : 사용 권장되지 않는 기능을 사용할 때 무시
//unused : 사용하지 않는 변수, 매개변수, 필드에 대한 경고를 숨긴다.
//all : 모든 경고 무시
public class SuppressExample {
	public static void main(String[] args) {
		int num = 100;
		DeprecatedExample de = new DeprecatedExample();
		de.oldMethod();
	}
}
