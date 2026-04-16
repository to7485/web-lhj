package ex3_bufferedstream;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReaderExample {
	public static void main(String[] args) {
		try(
			FileReader fr = new FileReader("test.txt");
			BufferedReader br = new BufferedReader(fr);
				) {
			String line;
			//readLine() : 한 줄 단위로 문자열을 읽어오는 메서드
			//내용이 긴것도 쉽게 읽어올 수 있음
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
