package ex1_exception.customException;

public class Account {

	private long balance; //잔액
	
	public Account() {};
	
	//잔액을 반환하는 getter
	public long getBalance() {
		return balance;
	}
	
	//돈을 전달받아서 입금을 하는 메서드 deposit()
	public void deposit(int money) {
		balance += money;
	}
	
	//인출
	public void withdraw(int money) throws InsufficientException{
		if(balance < money) {
			//강제로 예외 발생시키기
			throw new InsufficientException("잔고 부족 : " + (money-balance) +"원 모자람");
		}
		balance -= money;
	}
	
	
	
	
	
	
}
