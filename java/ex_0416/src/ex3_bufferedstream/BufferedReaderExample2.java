package ex3_bufferedstream;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedReaderExample2 {
	public static void main(String[] args) {
		//Scanner
		//- 속도가 느리다
		//- nextInt(), nextDouble()등 입력과 동시에 데이터 타입을
		//변환해주는 편의 기능이 많다.
		//하지만 내부적으로 정규표현식을 사용하여 입력을 분석하기 때문에
		//속도가 느려지는 원인이 된다.
		
		//BufferedReader
		//- 버퍼를 사용하기 때문에 속도가 빠르다
		//- 오직 문자열 단위로만 읽는다.
		//- 다른 타입으로 사용하려면 번거롭지만 직접 바꿔줘야 한다.
		//- 보조스트림이기 때문에 기반스트림이 필요하다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		
		
		
		
		
	}
}
