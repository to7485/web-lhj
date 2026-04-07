package ex3_String;

//범위를 가지고 사용하는 메서드의 특징
//대부분 끝값은 포함하지 않는다.


public class StringBuilderExample {
	public static void main(String[] args) {
		//toString()을 제외한 다른 메서드는 StringBuilder객체를 반환한다.
		//그렇기 때문에 연이어서 다른 메서드를 호출할 수 있는 메서드 체이닝
		//패턴을 사용할 수 있다.
		String data = new StringBuilder()
				.append("DEF")
				.insert(0, "ABC")
				.delete(3, 4)
				.toString();
		
		System.out.println(data);
		
		//자주 변경되는 문자열이 있을 때 String에 넣지 말고 StringBuilder에 넣어라
		
		
		
		
		
		
		
		
		
		
	}
}
