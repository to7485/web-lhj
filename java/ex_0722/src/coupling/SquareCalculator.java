package coupling;

//자료 결합도
//모듈간에 오직 필요한 값만 주고받는 형태
//한쪽 모듈이 변경되어도 다른 모듈에 전혀 영향을 주지 않는다.
//- 처리해야할 데이터 항목이 너무 많아지면 파라미터의 개수가 지나치게 늘어날 수 있다.
//- 메서드 호출 시 파라미터의 순서가 바뀌거나 잘못 전달될 위험이 생길 수 있다.
public class SquareCalculator {

	public int calculateSquare(int number) {
		return number * number;
	}
}
