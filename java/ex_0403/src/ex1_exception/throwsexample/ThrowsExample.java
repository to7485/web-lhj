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
}






