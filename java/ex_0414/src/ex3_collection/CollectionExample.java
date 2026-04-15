package ex3_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionExample {
	public static void main(String[] args) {
		//List, Set계열에서 공통적으로 쓰이는 메서드
		List<String> list = Arrays.asList("사과","바나나","포도");
		
		//Iterable 인터페이스
		//forEach()
		//컬렉션에 들어있는 요소를 하나씩 꺼내면서 람다로 처리할 때 사용하는 메서드
		list.forEach(s -> System.out.println(s));
		
		//Collection 인터페이스
		//removeIf()
		//조건에 맞는 요소를 삭제할 때 사용하는 메서드
		List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		
		nums.removeIf(x -> x % 2 == 0); //결과가 true인것들을 삭제
		System.out.println(nums);
		
		Set<String> names = new HashSet<String>();
		names.add("김민수");
		names.add("박갑수");
		names.add("홍길동");
		names.add("조민박");
		names.add("최자바");
		
		//이름에 "민" 글자가 들어있는 사람만 지운 후 출력하기
		names.removeIf(x -> x.contains("민"));
		
		System.out.println(names);
		
		//List 인터페이스
		//replaceAll() : 각 요소를 바꿀 때
		//sort() : 정렬 기준을 람다로 넘길 때
		
		List<String> names2 = new ArrayList<>(Arrays.asList("kim","lee","park"));
		
		names2.replaceAll(name -> name.toUpperCase());
		System.out.println(names2);
		
		//compareTo() : 문자열끼리 사전식 비교
		//사전순으로 뒤에있는게 더 큰 수라고 판단
		//음수 : a가 b보다 앞에 와야 한다.
		//0 : 둘이 같음
		//양수 : a가 b보다 뒤에 와야 한다.
		names2.sort((a,b) -> a.compareTo(b));
		System.out.println(names2);
		
		//Map 인터페이스
		
		//forEach(BiConsumer<K,V>)
		//키와 값을 같이 순회할 때 사용
		Map<String,Integer> map = new HashMap<>();
		map.put("사과", 1000);
		map.put("바나나", 2000);
		
		map.forEach((key, value) -> System.out.println(key+" : "+ value));
		
		//replaceAll()
		//모든값을 일괄 수정할 때 사용
		map.replaceAll((key,value) -> value + 500);
		System.out.println(map);
		
		
		
		
		
		
		
		
		
		
		
	}
}
