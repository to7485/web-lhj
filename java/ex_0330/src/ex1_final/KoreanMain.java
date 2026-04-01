package ex1_final;

public class KoreanMain {
	public static void main(String[] args) {
		
		Korean k1 = new Korean("123456-1234567","홍길동");
		
		System.out.println(k1.nation);
		System.out.println(k1.ssn);
		System.out.println(k1.name);
		
		//Final 필드는 값을 변경할 수 없음
		//k1.nation = "일본";
		//k1.ssn = "123-12-1234";
		k1.name = "나카무라";
		
		
		
		
		
		
		
		
	}
}
