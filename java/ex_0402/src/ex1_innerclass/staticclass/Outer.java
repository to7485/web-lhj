package ex1_innerclass.staticclass;

//정적 내부 클래스를 쓰는 이유
//관련 있는 클래스를 논리적으로 묶기 위해(논리적 : 역할이 연결되어있다)
//바깥객체 참조가 필요 없는 내부 구조를 만들기 위해

public class Outer {

	int a = 10; //일반 필드(멤버 변수)
	static int b = 20; //정적 필드(클래스 변수)
	
	//바깥클래스와 완전히 단절된것은 아니고, 필요하면 객체를 전달받아 사용할 수 있다.
	static class Inner{
		//정적 내부 클래스는 Outer 객체에 연결되어 있지 않기 때문이다.
		void print() {
			//System.out.println(a); 오류
			System.out.println(b); //가능
		}
		
		void print(Outer outer) {
			System.out.println(outer.a);
		}
	}
}





