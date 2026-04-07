package ex1_exception.throwsexample;

public class ThrowsExample {
	public static void main(String[] args) {
		try {
			findClass();
		} catch (ClassNotFoundException e) {
			System.out.println("예외 처리 : " + e.toString());
		}
	}
	
	//나열해야 하는 예외 클래스 많은 경우 throws Exception 또는 throws Throwable만으로
	//모든 예외를 간단히 넘길수도 있다.
	public static void findClass() throws ClassNotFoundException{
		//java.lang.String2클래스를 찾아서 메모리에 올리는 기능
		Class.forName("java.lang.String2");
	}
	
	//인출하는 기능
	//흐름이 끊기지는 않음
	//호출한쪽에서 결과를 직접판단해야 한다.
//	public static boolean widthdraw(int money) {
//		if(money <= 0) {
//			System.out.println("금액 오류");
//			return false;
//		}
//		
//		if (balance < money) {
//			System.out.println("잔액 부족");
//			return false;
//		}
//		
//		balance -= money;
//		return true;
//	}
	
	//예외처리 방식
	//잘못된 상황이면 강제로 중단
	//호출한쪽에서 try-catch로 처리
	public static void widthdraw(int money) throws Exception {
		if(money <= 0) {
			throw new IllegalArgumentException("금액 오류");
		}
		
		if (balance < money) {
			throw new IllegalArgumentException("잔액 부족");
		}
		
		balance -= money;
	}
	
	
	
	
	
	
	
	
	
	
	
}






