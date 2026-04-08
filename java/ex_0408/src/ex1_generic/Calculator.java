package ex1_generic;

//타입 한정 키워드 extends
// T extends 제한타입
//Number : 숫자를 다루는 클래스들의 공통 부모 클래스
//Integer, Double, Long ,Float
//T에는 Number타입이거나 Number를 상속한 하위클래스만 가능하다.
public class Calculator<T extends Number> {
	void add(T a, T b) {}
	void min(T a, T b) {}
	void mul(T a, T b) {}
	void div(T a, T b) {}
}
