package coupling;

//한 모듈이 다른 모듈 내부 변수나 private/내부영역에 직접 접근해 강제로 조작
public class ContentCouplingExample {

	//은행 계좌 클래스
	static class BankAccount{
		public int balance = 10000;
	}
	
	//객체지향의 가장 기본적인 원칙인 '캡슐화'와 '정보 은닉'을 완전히 무너뜨림
	//BankAccount 클래스 내부의 변수명이나 데이터구조가 바뀌면 HackerModule은 즉시 에러가 발생한다.
	//한 모듈의 변경이 다른 모듈을 직접 파괴하므로 유지보수가 전혀 불가능하다.
	static class HackerModule{
		public void stealMoney(BankAccount account) {
			account.balance = 0;
		}
	}
}
