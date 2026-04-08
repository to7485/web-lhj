package ex3_generic;

import ex3_generic.exam.Box;

class Pair<T,U>{
	private T first;
	private U second;
	
	public Pair(T first, U second) {
		this.first = first;
		this.second = second;
	}
	
	//first와 second의 값을 출력하는 print()메서드 만들기
	public void print() {
		System.out.println("첫번째 값 : " + first);
		System.out.println("두번째 값 : " + second);
	}
}

class Box<V>{
	private V value;
	
	public void setValue(V value) {
		this.value = value;
	}
	
	public V getValue() {
		return value;
	}
}

public class NestingExample {
	public static void main(String[] args) {
		//중첩 제네릭
		Box<Pair<String,Integer>> box = new Box<>();
		
		Pair<String,Integer> pair = new Pair<>("홍길동",30);
		
		box.setValue(pair);
		
		box.getValue().print();
	}
}







