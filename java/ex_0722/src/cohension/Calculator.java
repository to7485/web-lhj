package cohension;

//1. 기능적 응집도
//하나의 작업만 깔끔하게 수행하는 모듈
//- 너무 잘게 쪼개다보면 클라스나 메서드의 개수가 지나치게 많아질 수 있다
//- 개별 메서드는 완벽하지만, 전체적은 프로그램의 실행 흐름을 파악하려면
//여러 메서드를 넘나들어야 한다.
public class Calculator {

	//오직 '두 수의 더하기'라는 단 하나의 목적만 수행한다.
	public int add(int x, int y) {
		return x + y;
	}
	
}
