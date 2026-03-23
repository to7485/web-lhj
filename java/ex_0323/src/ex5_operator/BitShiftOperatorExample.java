package ex5_operator;

public class BitShiftOperatorExample {
	public static void main(String[] args) {
		int num1 = 1; //0001
		int result1 = num1 << 3;
		int result2 = num1 * (int)Math.pow(2, 3);
		System.out.println("result1 : " + result1);
		
		int num2 = -8;//00001000 -> 11110111 -> 11111000
		//11111111 11111111 11111111 11111000
		int result3 = num2 >> 3;
		//>> : 부호는 유지하면서 오른쪽으로 이동하는 연산
		//11111111 11111111 11111111 11111111
		//>>> : 무조건 0으로 채움
		//00011111 11111111 11111111 11111111
		System.out.println("result3 : " + result3);
		
		//11111111 -> 01111111 -> 00000000 -> 00000001

		System.out.println(1 >> 1);
		
		
		
		
		
		
		
	}
}
