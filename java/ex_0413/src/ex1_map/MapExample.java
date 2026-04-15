package ex1_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//Map은 키(key)와 값(value)을 한 쌍으로 저장하는 자료구조
//키(key) : 값(value)를 찾기 위한 이름표 역할

//키는 중복될 수 없다.
//값은 중복될 수 있다.

//index가 없고 key를 통해 데이터에 접근한다.
public class MapExample {
	public static void main(String[] args) {
		//Map은 Key와 Value의 제네릭 타입을 각각 설정해야 한다.
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		//map에 데이터를 저장하는 방법
		//put(K k, V v);
		map.put("사과", 1000);
		map.put("바나나", 2000);
		map.put("포도", 3000);
		
		//내가 넣은 데이터 순으로 출력을 보장하지는 않는다.
		System.out.println(map);
		
		//저장한 데이터를 꺼내는 방법
		//get(key)
		
		int price = map.get("사과");
		System.out.println("사과의 가격 : " + price);
		
		//없는 key를 조회하려고 한다면 null값이 나온다.
		System.out.println(map.get("딸기"));
		
		//Key가 중복되면 value를 덮어쓴다.
		map.put("사과", 1500);
		
		System.out.println("사과의 가격 : " + map.get("사과"));
		
		//데이터 삭제하기
		//remove(key)
		//삭제하고 난 후 value값을 반환한다.
		System.out.println("삭제한 값 : " + map.remove("사과"));
		System.out.println(map);
		
		//key의 존재여부 확인하기
		//containsKey(key)
		
		if(map.containsKey("포도")) {
			System.out.println("포도가 존재합니다.");
		}
		
		//value의 존재여부 확인
		//containsValue(value)
		if(map.containsValue(1500)) {
			System.out.println("1500원짜리 상품이 있습니다.");
		}
		
		//map에 들어있는 데이터의 개수 확인
		//size()
		System.out.println("map의 크기 : " + map.size());
		
		//컬렉션이 비어있는지 확인
		//isEmpty()
		System.out.println("map에 데이터가 들어있는지 확인 : " + map.isEmpty());
		
		//Map에서 전체 데이터를 다루는 방법
		
		//map에 들어있는 모든 key를 Set으로 반환
		//keySet()
		
		Set<String> set = map.keySet();
		for(String s : set) {
			System.out.println(s);
		}
		
		//key-value 쌍 전체를 Set<Entry<K,V>> 형태로 반환
		Set<Map.Entry<String, Integer>> set2 = map.entrySet();
		
		for(Map.Entry<String, Integer> entry : set2) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		
		Map<Integer,Character> map2 = new HashMap<Integer, Character>();
		map2.put(1004, 'C');
		map2.put(45, 'A');
		map2.put(29, 'D');
		
		//key가 존재하면 value를 반환하고, 없으면 기본값(default)을 반환하는 메서드
		//getOrDefault(Object key, V defaultValue);
		
		//get() 했을 때 key가 없으면 null을 반환
		
		System.out.println(map.getOrDefault("사과", 1500));
	}
}










