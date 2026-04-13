package ex1_set.TreeSet;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
	public static void main(String[] args) {
		//TreeSet
		//데이터를 자동으로 정렬하면서 저장하는 Set
		//1. 중복이 허용되지 않는다.
		
		TreeSet<Integer> scores = new TreeSet<Integer>();
		scores.add(50);
		scores.add(10);
		scores.add(30);
		scores.add(20);
		
		System.out.println(scores);
		
		//TreeSet은 정렬되어 있기 때문에 특정 범위의 데이터 검색이 편하다.
		System.out.println(scores.first());//가장 작은값
		System.out.println(scores.last());//가장 큰 값
		
		//lower(x)
		//x보다 작은값 중 가장 가까운 값
		System.out.println(scores.lower(30));
		
		//higher(x)
		//x보다 큰 값 중 가장 가까운 값
		System.out.println(scores.higher(30));
		
		//중위 순회
		//왼쪽 -> 부모 -> 오른쪽
		//왼쪽끝 -> 10
		//10의 오른쪽 -> 20
		//루트 -> 30
		//오른쪽 50
		
		
		
		
		
	}
}
