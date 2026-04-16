package ex3_bufferedstream.exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class SearchExample {
	public static void main(String[] args) {
		//사용자로부터 검색할 단어를 입력받고, stroy.txt파일에서
		//해당 단어가 포함된 줄을 출력하세요
		
		//실행 예시
		//검색어 입력 : 자바
		//자바는 객체지향 언어이다.
		//오늘 자바 공부를 했다.
		
		//파일은 한줄씩읽는다.
		
		//권장 스트림
		//BufferedReader
		
		try(
				BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
				BufferedReader file = new BufferedReader(new FileReader("story.txt"));
				){
			
			System.out.print("검색어 입력 : ");
			String keyword = keyboard.readLine();
			
			String line;
			while((line = file.readLine()) != null) {
				if(line.contains(keyword)) {
					System.out.println(line);
				}
			}
			
			
		} catch(Exception e) {
			
		}
		
		
		
		
		
		
		
		
		
		
		

	}
}
