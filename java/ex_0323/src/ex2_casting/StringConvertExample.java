package ex2_casting;

public class StringConvertExample {
	public static void main(String[] args) {
		//문자열 -> 기본타입
		String s = "10";
		int value1 = Integer.parseInt(s);
		double value2 = Double.parseDouble("3.14");
		boolean value3 = Boolean.parseBoolean("true");
		
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		
		//기본타입 -> 문자열
		//String.valueOf(데이터)
		String str1 = String.valueOf(10);
		String str2 = String.valueOf(3.14);
		String str3 = String.valueOf("true");
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		
	}
}
