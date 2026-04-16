package ex1_bytestream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			//내가 기록하려고 할 때 목적지가 없어질수도 있기 때문에 예외가 발생할 수도 있기 때문에
			//예외처리를 해줘야 한다.
			
			//목적지에 파일이나 폴더가 없으면 만들어준다.
			 fos = new FileOutputStream("test.txt",true);
			
			//목적지까지 가서 작성하려고 할 때 없을수도 있기 때문에
			//예외가 발생할 수 있어 예외처리
			fos.write('f');
			fos.write('i');
			fos.write('l');
			fos.write('e');
			
			String msg = "fileOutput 예제입니다.\n";
			String msg2 = "여러줄도 가능합니다.\n";
			
			//문자열을 byte배열로 변환하기
			fos.write(msg.getBytes());
			fos.write(msg2.getBytes());
			
			System.out.println("작성 완료!");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}







