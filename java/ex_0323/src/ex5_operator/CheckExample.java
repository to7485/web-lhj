package ex5_operator;

public class CheckExample {
	public static void main(String[] args) {
		int x = 5;
		double y = 0.0;
		double z = x / y;
		
		//Infinite : 무한대
		System.out.println(Double.isInfinite(z));
		
		z = x % y;
		
		//NaN : Not A Number
		System.out.println(Double.isNaN(z));
	}
}
