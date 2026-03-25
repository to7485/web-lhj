package ex7_array;

public class ArrayExample {
	public static void main(String[] args) {
		//{1,2,3,4,5}; -> 초기화 리스트
		//배열을 선언함과 동시에 초기화 리스트를 사용하는것이 가능하다.
		int[] arr = {1,2,3,4,5};
		
		int[] arr2; //배열의 선언
		
		//arr2 = {100,200,300}; 선언후 초기화 리스트를 대입할 수는 없다.
		
		//new 연산자를 통한 배열의 생성
		//값이 들어있지는 않지만 후에 값을 저장할 목적으로 배열을 미리 생성할 수 있다.
		int[] ar = new int[5];//int 크기만큼 5개의 공간이 확보된 배열
		
		//new 연산자로 배열을 처음 생성하면 배열 항목은 기본값으로 초기화된다.
		//정수형 : 0
		//실수형 : 0.0
		//문자형 : ''
		//참조형 : null
		
		//배열의 각 공간에 접근하여 값을 대입할 수 있다.
		ar[0] = 100;
		ar[1] = 200;
		ar[2] = 300;
		ar[3] = 400;
		ar[4] = 500;
		
//		System.out.println(ar[0]);
//		System.out.println(ar[1]);
//		System.out.println(ar[2]);
//		System.out.println(ar[3]);
//		System.out.println(ar[4]);
		
		for(int i = 0; i <ar.length; i++) {
			System.out.println(ar[i]);
		}
		
		int[] iAr = {1,2,3,4,5,6,7,8,9,10};
		
		int sum = 0;
		//배열 iAr에 들어있는 모든 요소의 합을 구하세요
		for(int i = 0; i <iAr.length; i++) {
			sum += iAr[i];
		}
		System.out.println("총 합 : " + sum);
		
		//03.27까지
		//1. 문자열의 불변의 법칙
		//2. String을 이용한 문제 1개 출제하기
		//ㄴ 배우지 않은 메서드를 사용해도 괜찮음
		
		
		
		
		
		
		
		
		
		
	}
}
