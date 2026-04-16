package ex1_bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CoypExample {
	public static void main(String[] args) {
		//상대경로에 있는 이미지 파일을 바이트기반 스트림으로 읽어서
		//복사본 만들기 복사본 이름 : wall_copy.jpg
		//복사하면서 걸리는 시간을 currentTimeMillis();로 측정하기
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("wall.jpg");
			out = new FileOutputStream("wall_copy2.jpg");
			byte[] buffer = new byte[512];
			
			long start = System.currentTimeMillis();
			System.out.println("이미지 읽기 시작");
			
			int data = 0;
			//1바트씩 파일을 읽어와서
			while((data = in.read(buffer)) != -1) {
				//바로 작성하기
				//buffer의 0부터 data개만큼 출력파일에 기록
				out.write(buffer,0,data);
			}
			//파일은 4mb임
			//우리가 전달한 배열은 512byte
			//우리가 전달한 파일을 512바이트씩 잘라서 여러번 읽고 쓰는 방식
			
			
			
			System.out.println("이미지 읽기 종료");
			long end = System.currentTimeMillis();
			long time = (end - start)/1000;
			
			System.out.println(time+"초");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				//닫을 때는 역순으로 닫는다.
				if(out != null) {
					out.close();
				}
				
				if(in != null) {
					in.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
