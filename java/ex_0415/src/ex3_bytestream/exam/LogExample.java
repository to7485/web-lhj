package ex3_bytestream.exam;

import java.io.File;
import java.io.FileInputStream;

public class LogExample {
	public static void main(String[] args) {
		//error.log파일을 읽어서 "ERROR"라는 단어가 몇번 등장하는지 출력하세요
		File f = new File("logs/error.log");
		byte[] read = new byte[(int)f.length()];
		String content = "";
		try {
			FileInputStream fis = new FileInputStream("logs/error.log");
			fis.read(read);
			
			content = new String(read);
			
			int count = 0;
			int index = 0;
			
			//
			while((index = content.indexOf("ERROR",index))!= -1) {
				count++;
				index += "ERROR".length();
			}
			
			System.out.println("ERROR의 개수 : " + count);
			
			fis.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
