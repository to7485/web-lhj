package ex1_bytestream;

public class ScannerExample {
	public static void main(String[] args) {
		byte[] keyboard = new byte[100];
		
		try {
			System.out.print("값 : ");
			
			//키보드에서 입력을 받을 수 있다.
			//System클래스의 in필드는 키보드 입력을 받기 위한 표준 입력 스트림
			//문자,숫자,파일 데이터처럼 들어오는 모든 입력을 바이트로 받는다.
			//그걸 나중에 문자열로 해석한다.
			System.in.read(keyboard);
			
			String s = new String(keyboard).trim();
			System.out.println(s);
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
