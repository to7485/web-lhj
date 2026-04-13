package ex3_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Collections 클래스
//컬렉션을 다룰 때 자주 쓰는 기능들을 static 메서드로 모아놓은 클래스
public class CollectionsExample {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(30);
		numbers.add(10);
		numbers.add(20);
		
		System.out.println(numbers);
		
		//오름차순 정렬
		Collections.sort(numbers);
		
		System.out.println(numbers);
		
		List<String> fruits = new ArrayList<>();
		
		fruits.add("banana");
		fruits.add("apple");
		fruits.add("cherry");
		
		System.out.println(fruits);
		
		//문자열은 사전순으로 정렬이된다.
		Collections.sort(fruits);
		
		System.out.println(fruits);
		
		//내림차순정렬
		//reverseOrder();
		Collections.sort(numbers, Collections.reverseOrder());
		
		System.out.println(numbers);
		System.out.println("-----------------");
		//순서 뒤집기
		//reverse();
		
		List<Integer> numbers2 = new ArrayList<>();
		numbers2.add(30);
		numbers2.add(10);
		numbers2.add(20);
		
		System.out.println(numbers2);
		Collections.reverse(numbers2);
		System.out.println(numbers2);
		System.out.println("-----------------");
		//섞기
		//shuffle()
		List<Integer> numbers3 = new ArrayList<>();
		numbers3.add(1);
		numbers3.add(2);
		numbers3.add(3);
		numbers3.add(4);
		numbers3.add(5);
		numbers3.add(6);
		numbers3.add(7);
		numbers3.add(8);
		numbers3.add(9);
		
		System.out.println(numbers3);
		Collections.shuffle(numbers3);
		System.out.println(numbers3);
		
		//최대값, 최소값
		//max(),min()
		
		System.out.println("-----------------");
		
		int max = Collections.max(numbers3);
		int min = Collections.min(numbers3);
		
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		
		//문자열의 최대값 최소값은 사전순으로 뒤에나오는게 더 크다고 생각을 한다.
		System.out.println(Collections.max(fruits));
		
		
		
		
		
		
		
		
		
		
	}
}
