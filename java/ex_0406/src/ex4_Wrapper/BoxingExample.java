package ex4_Wrapper;

public class BoxingExample {
	public static void main(String[] args) {
		//Boxing
		Integer obj = 100;
		System.out.println(obj+100);
		
		System.out.println(obj.intValue());
		
		//Unboxing
		int result = obj;
		System.out.println(result);
	}
}
