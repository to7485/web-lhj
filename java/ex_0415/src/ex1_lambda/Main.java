package ex1_lambda;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		//메서드 참조 : 람다식을 더 짧게 쓸 수 있는 참조
		//이미 존재하는 메서드를 그대로 호출만 하는 형태일 때 사용 가능
		List<String> names = Arrays.asList("Kim","Lee","Park");
		//메서드 참조를 하는 이유
		//names.forEach(s -> System.out.println(s));
		
		//람다식은 리스트에 있는 요소를 받아서 출력만 한다.
		//직접 계산을 하거나 로직을 조합하는 형태가 아니다.
		//기존에 있는 메서드를 전달만 한 상태이다.
		names.forEach(System.out::println);
		
		//의미는 같으나 코드가 더 짧고 의도가 분명하다
		
		//메서드 참조 사용하는법
		//클래스명::메서드명
		//변수명::메서드명
	}
}







