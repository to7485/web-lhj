package ex1_generic;
//와일드카드
//제네릭 타입에서 "정확한 타입은 모르겠지만, 어떤 범위안에 있는 타입이다."
//라고 표현할 때 사용한다.
//List<String> : 정확히 String을 담을 수 있는 리스트
//List<Integer> : 정확히 Integer를 담는 리스트

import java.util.List;

//와일드카드의 기본문법
//<?> : 타입을 모름, 아무 타입이나 가능함
//<? extends T>: T 또는 T의 자식 타입만 가능함 (상한 제한)
//<? super T> : T 또는 T의 부모 타입만 가능함(하한 제한)

//<T extends Number> : 타입한정 -> 타입을 정의하는 것

//와일드카드가 써있는것들은 대부분 읽기 전용이다.
//와일드카드는 매개변수에서 사용이 되는 경우가 많다.
//이미 만들어진 객체를 받을 때 사용한다.
public class Wildcards {

	//?에 어떤 타입이 들어올지 알 수 없기 때문이다.
	public void printList(List<?> list) {
		for(Object obj : list) {
			System.out.println(obj);
		}
	}
	
	//상한 제한  와일드카드
	public void printNumbers(List<? extends Number> list) {
		for(Number obj : list) {
			System.out.println(obj);
		}
	}
	
	
	
	
	
	
	
	
}
