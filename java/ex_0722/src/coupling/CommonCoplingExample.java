package coupling;

//하나의 전역변수를 공유하고 직접 수정하는 형태
public class CommonCoplingExample {

	//전역으로 공유되는 상태 정보
	static class GlobalState{
		public static int globalDiscountRate = 10; //전역 할인율 변수
	}
	
	//할인률 변경 모듈
	static class ModuleA{
		public void updateDiscount() {
			GlobalState.globalDiscountRate = 20;
		}
	}
	
	//가격 계산 모듈
	//ModuleA가 전역변수를 바꾼 파급효과가 ModuleB에 그대로 전달되어 얘기치 않은 문제가 발생할 수 있다.
	//프로그램 전체에서 어느 모듈이 언제 전역 변수 값을 바꿨는지 추적하기가 힘들어 디버깅이 어려워짐
	//모듈 간 독립성이 사라져 특정 모듈만 떼어내어 재사용하는것이 불가능하다.
	static class ModuleB{
		public void printPrice(int price) {
			int finalPrice = price - GlobalState.globalDiscountRate;
			System.out.println("적용된 할인율 후 가격 : " + finalPrice);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
