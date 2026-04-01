package ex6_sealed;

//봉인된 클래스를 상속하는 자식 클래스는 final 또는
//non-sealed키워드로 선언하거나 sealed 키워드를 사용해서
//또 다른 봉인 클래스로 선언해야 한다.
public final class Employee extends Person {

	@Override
	public void work() {
		System.out.println("제품을 생산합니다.");
	}
}
