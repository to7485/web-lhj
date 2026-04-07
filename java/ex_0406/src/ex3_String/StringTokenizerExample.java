package ex3_String;

import java.util.Arrays;
import java.util.StringTokenizer;

public class StringTokenizerExample {
	public static void main(String[] args) {
		String data1 = "홍길동&박길동,이길동";
		//split()으로 분리하게 되면 불필요한 배열이 만들어지게 된다.
		String[] arr = data1.split("&|,");
		System.out.println(Arrays.toString(arr));
		
		//StringTokenizer클래스
		//문자열을 일정한 기준(구분자)으로 빠르게 잘라서 처리하기 위해 사용한다.
		
		String data2 = "홍길동/이수홍/박연수";
		StringTokenizer st = new StringTokenizer(data2,"/");
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
		 
		
		
		
		
		
		
		
		
	}
}
