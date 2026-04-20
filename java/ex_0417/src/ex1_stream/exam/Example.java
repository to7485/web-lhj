package ex1_stream.exam;

import java.util.Arrays;
import java.util.List;

public class Example {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(3,5,7,8,10,4,1,2,6,9,1,1,1,3,3,3);
		
		//짝수만 골라 10을 더한뒤 출력하세요
		numbers.stream()
		.filter(x -> x % 2 == 0)
		.map(x -> x + 10)
		.forEach(x -> System.out.print(x+" "));
		System.out.println();
		
		
		List<String> words = Arrays.asList("java", "spring", "react", "db", "server");
		
		//문자열의 길이가 5이상인 문자열남 남긴 뒤
		//대문자로 변환하여 출력하기
		
		words.stream()
		.filter(x -> x.length() >=5)
		.map(String::toUpperCase)
		.forEach(x -> System.out.print(x+" "));
		System.out.println();
		
		
		
		
	}
}
