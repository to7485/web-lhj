package ex2_function;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

//람다식의 합성 : 여러 함수를 하나의 함수처럼 연결해서 새로운 함수를 만드는것

//람다식의 결합 : 함수 실행을 순서대로 이어서 실행

public class FunctionExample {
	public static void main(String[] args) {
		//java에서는 다음 인터페이스에서 합성을 지원한다.
		//Function<T,R>
		//Predicate<T>
		//Consumer<T>
		
		//핵심 메서드
		//andThen()
		//현재 함수를 실행 -> 다음함수를 실행한다.
		
		Function<Integer, Integer> multiply = x -> x*2;
		Function<Integer, Integer> add = x -> x + 3;
		
		Function<Integer,Integer> result = multiply.andThen(add);
		
		System.out.println(result.apply(5));
		
		//5 -> multiply -> 10 -> add -> 13
		
		//compose()
		//괄호 안의 함수를 실행 -> 앞에있는 함수를 실행
		
		result = multiply.compose(add);
		System.out.println(result.apply(5));
		
		//5 -> add -> 8 -> multiply -> 16
		
		//Predicate의 결합(조건 합치기)
		
		Predicate<Integer> isPositive = x -> x > 0;
		Predicate<Integer> isEven = x -> x % 2 == 0;
		
		//and()
		Predicate<Integer> result2 = isPositive.and(isEven);
		
		System.out.println(result2.test(4));
		System.out.println(result2.test(-2));
		
		//isPositive.and(isEven);
		//x > 0 && x % 2 == 0
		System.out.println("-----------------");
		
		//or()
		result2 = isPositive.or(isEven);
		
		System.out.println(result2.test(4));
		System.out.println(result2.test(-2));
		
		System.out.println("-----------------");
		
		//negate()
		result2 = isPositive.negate();
		System.out.println(result2.test(5));
		
		// !(x > 0)
		
		//Consumer<T>의 결합
		//반환값이 없는 함수라서 순서대로 실행하는 결합만 가능
		
		//andThen()
		
		Consumer<String> print1 = s -> System.out.println("1 : " + s);
		Consumer<String> print2 = s -> System.out.println("2 : " + s);
		
		Consumer<String> result3 = print1.andThen(print2);
		
		result3.accept("Hello");
		
		//람다식은 조립이 가능한 함수다.
		
		//문자열을 입력받아서 다음의 처리를 하는 람다식 함수 파이프라인 만들기
		//1. 공백 제거
		//2. 소문자로 변환
		//3. "user_" 접두사 붙이기
		
		Function<String, String> remove = s -> s.replace(" ", "");
		Function<String, String> lower = s -> s.toLowerCase();
		Function<String, String> addPrefix = s -> "user_" + s;
		
		Function<String,String> pipeline = remove.andThen(lower).andThen(addPrefix);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 입력 : ");
		String input = sc.nextLine();
		String r = pipeline.apply(input);
		System.out.println(r);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
