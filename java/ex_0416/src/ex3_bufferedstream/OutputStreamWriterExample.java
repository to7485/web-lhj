package ex3_bufferedstream;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class OutputStreamWriterExample {
	public static void main(String[] args) {
		//바이트 기반스트림 OutputStream을 문자기반의 스트림으로
		//변환하는 보조스트림이다.
		
		try (
				FileOutputStream fos = new FileOutputStream("test.txt");
				OutputStreamWriter os = new OutputStreamWriter(fos,"UTF-8");
				){
			
			String[] strArray = {
					"OutputStreamWriter에 대해서 배웁니다.",
					"we are learnng about OutputStreamWriter"
			};
			
			//test.txt에 배열에 들어있는 문자열을 순차적으로 넣기
			for(String str : strArray) {
				os.write(str+"\n");
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
