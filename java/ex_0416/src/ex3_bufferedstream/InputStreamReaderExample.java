package ex3_bufferedstream;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class InputStreamReaderExample {
	public static void main(String[] args) {
		//InputStreamReader
		//Java입출력에서 바이스 스트림을 문자 스트림으로 변환해주는 다리역할
		
		try (
				FileInputStream in = new FileInputStream("test.txt");
				//InputStreamReader(기반,인코딩 타입);
				InputStreamReader is = new InputStreamReader(in, "UTF-8");
				){
			
			
			int read = 0;
			while((read = is.read()) != -1) {
				System.out.print((char)read);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
