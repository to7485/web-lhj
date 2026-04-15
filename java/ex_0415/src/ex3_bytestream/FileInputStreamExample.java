package ex3_bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//스트림(stream)
//데이터가 한 방향으로 흐르는 통로이다.
//파일에 데이터를 저장하거나, 파일에서 데이터를 읽어올 때
//자바는 데이터를 한 번에 통째로 다루기보다 흐름처럼 조금씩
//읽고 쓰는 방식으로 처리한다.

//바이트기반스트림
//데이터를 1바이트(8비트)로 처리하는 스트림이다.
//데이터를 아주 작은 단위인 바이트로 읽고 쓴다.
public class FileInputStreamExample {
	public static void main(String[] args) {
		
		byte[] read = new byte[100];
		
		//파일에서 바이트 단위로 데이터를 읽어오는 클래스
		//파일이 없으면 예외가 발생할 수 있기 때문에 예외처리를 해줘야 한다.
		try {
			FileInputStream fis = new FileInputStream("test.txt");
			
			//read()
			//파일에서 1바이트를 읽어서 int로 반환합니다.
			//int로 반환하는 이유
			//파일의 끝(End Of File)을 표현하기 위해서이다.-> -1
			int data;
//			while((data = fis.read())!= -1) {
//				System.out.print((char)data);
//			}
			
			//read()메서드는 1바이트씩 읽어들이지만
			//read(byte[] b)는 한번에 읽어와서 배열에 집어넣는다.
			fis.read(read);
			
			String result =new String(read);
			
			System.out.println(result);
			
			//스트림을 사용하고나면 반드시 닫아야 한다.
			fis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//read()메서드
		//1바이트를 읽는다.
		//읽은 바이트 값으 int로 반환
		//더이상 읽을 데이터가 없으면 -1을 반환
		
		
		
		
		
	}
}








