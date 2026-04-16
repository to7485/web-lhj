package ex2_charstream;

import java.io.FileWriter;

public class FileWriterExample {
	public static void main(String[] args) {
		//이미지,영상, 실행파일 -> 바이트기반의 스트림
		//텍스트 -> 문자기반의 스트림
		try {
			FileWriter fw = new FileWriter("hello.txt",true);
			fw.write("첫번째 줄 작성합니다.\n");
			fw.write("두번째 줄도 문제 없습니다.");
			
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
