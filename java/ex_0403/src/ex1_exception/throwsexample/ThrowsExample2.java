package ex1_exception.throwsexample;

public class ThrowsExample2 {
	//main 메서드에서도 throws 키워드를 사용해서 예외를 떠넘길수 있다.
	//결국 JVM이 최종적으로 예외 처리를 하게 된다.
	//JVM은 예외의 내용을 콘솔에 출력하는것으로 예외처리를 한다.
	public static void main(String[] args) throws Exception {
		findClass();
	}
	
	//나열해야 하는 예외 클래스 많은 경우 throws Exception 또는 throws Throwable만으로
	//모든 예외를 간단히 넘길수도 있다.
	public static void findClass() throws ClassNotFoundException{
		//java.lang.String2클래스를 찾아서 메모리에 올리는 기능
		Class.forName("java.lang.String2");
	}
}
