package ex2_charstream.exam;

import java.io.FileReader;

public class Example {
	public static void main(String[] args) {
		//test.txt 파일에 아무 내용이나 적는다.
		//내용을 읽어와서 영어 대문자와 소문자가 몇개있는지
		//각각 출력하세요
		
		//대문자 : 7
		//소문자 : 22
		
		int upper = 0;
		int lower = 0;
		
		try(FileReader fr = new FileReader("test.txt")){
			int code = 0;
			while((code = fr.read()) != -1) {
				if(code >= 'A' && code <= 'Z') {
					upper++;
				}
				
				if(code >= 'a' && code <= 'z') {
					lower++;
				}
			}
			
			System.out.println("대문자 : " + upper);
			System.out.println("소문자 : " + lower);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
		
	}
}
