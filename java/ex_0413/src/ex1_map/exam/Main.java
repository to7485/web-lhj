package ex1_map.exam;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("사과", 1500);
		map.put("바나나", 1000);
		map.put("포도", 2000);
		
		System.out.println(map.getOrDefault("포도", 100));
		System.out.println(map.get("포도"));
		
		Collection<Integer> prices = map.values();
		System.out.println("---------------");
		for(int i : prices) {
			System.out.println(i);
		}
		System.out.println("---------------");
		Calculator c = new Calculator();
		System.out.println(c.add(10, 7));
		
		
		
		
		
	}
}
