package ex1_exception.customException;

public class InsufficientException extends Exception{
	
	//예외 메시지는 부모 생성자의 매개값으로 넘겨주는데
	//공통 메서드인 getMessage()의 반환값으로 사용하기 위함이다.
	public InsufficientException(String message) {
		super(message);
	}

}
