package ex1_generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Casting {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3));
		
		//print(list);//컴파일에러
	}
	
	public static void print(List<Object> list) {
		for(Object e : list) {
			System.out.println(e);
		}
	}
}
