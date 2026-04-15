package ex1_map.exam;

import java.util.HashMap;
import java.util.Map;

public class MaxFinder {
	public static void main(String[] args) {
		int [] arr = {1,3,2,3,4,3,2,2,2};
		
		//숫자별 등장 횟수를 HashMap<Integer,Integer>로 센다.
		//가장 큰 빈도수를 가진 숫자를 찾는다.
		
		//가장 많이 등장한 숫자 : X
		//등장 횟수 : X
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int num : arr) {
			if(map.containsKey(num)) {
				map.put(num, map.get(num)+1);
			} else {
				map.put(num, 1);
			}
		}
		
		int maxCount = 0;
		int result = 0;
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				result = entry.getKey();
			}
		}
		
		System.out.println("가장 많이 등장한 숫자 : " + result);
		System.out.println("등장 횟수 : " + maxCount);
		
		
		
		
		
	}
}
