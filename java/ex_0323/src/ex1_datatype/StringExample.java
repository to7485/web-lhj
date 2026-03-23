package ex1_datatype;

public class StringExample {
	public static void main(String[] args) {
		//char c1 = "홍길동";
		
		//참조 자료형은 주소값을 저장한다고 했는데?
		String s1 = "박길동";
		
		//출력하니까 들어있는 값이 나오네?
		//원래는 주소값을 돌려주는게 맞음
		//하지만 문자열은 자주쓰다보니 주소에 들어있는 값을
		//반환하도록 설정이 되어있다.
		System.out.println(s1);
		
		//데이터를 변수에 넣어서 사용하는 이유
		//데이터를 저장해두고, 재사용하기 위함
		
		//이스케이프 문자
		//문자열 안에서 특수한 기능을 수행하기 위한 문자
		System.out.println("안녕하세요 \"홍길동\"입니다.");
		
		// \(백슬래시)가 붙으면 "이 문자는 특별한 의미로 처리해라"
		// \n : 줄바꿈
		System.out.println("hello\nworld");
		// \t : 탭 1개만큼 들여쓰기
		System.out.println("hello\tworld");
		// \" : 큰따옴표 출력
		// \' : 작은 따옴표 출력
		// \\ : 백슬래시 출력
		
		//java13부터는 텍스트블록 문법을 제공한다.
		//println을 쓰거나 \n을 쓸필요 없이
		//작성된 그대로의 문자열을 저장한다.
		String str = """ 
		"영역" 사이에
		작성을 합니다.		
		""";
		
		System.out.println(str);	
	}
}
