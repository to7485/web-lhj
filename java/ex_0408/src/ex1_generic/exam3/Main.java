package ex1_generic.exam3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Dog> dogs = new ArrayList<Dog>();
		List<Cat> cats = new ArrayList<>();
		
		AnimalPrint ap = new AnimalPrint();
		
		ap.printAnimal(dogs);
		ap.printAnimal(cats);
		
		List<Integer> a = Arrays.asList(1,2,3,4,5);
		List<Double> b = Arrays.asList(1.2,2.2,3.3,4.4,5.5);
		
		System.out.println(sum(a));
		System.out.println(sum(b));
		
		
	}
	
	//숫자타입의 list를 받아서 총합을 구하는 sum메서드 만들기 반환타입은 double
	public static double sum(List<? extends Number> list) {
		double total = 0;
		for(Number n : list) {
			total += n.doubleValue();
		}
		return total;
	}
	
	
	
	
	
	
	
	
}
