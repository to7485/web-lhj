package ex1_exception;

public class CatchExample {
	public static void main(String[] args) {
		//catch메서드는 시스템으로부터 넘어오는 예외 객체를 받아서 처리한다.
		try {
			String[] array = {"100","1oo"};
			
			for(int i = 0; i <= array.length; i++) {
				int value = Integer.parseInt(array[i]);
			}
			//해당타입의 예외가 발생하면 catch블록이 실행된다.
		} catch (NumberFormatException e) {
			System.out.println("숫자로 변환할 수 없음 : " + e.getMessage());
		} catch(ArrayIndexOutOfBoundsException | NullPointerException e) {
			System.out.println("배열 인덱스가 초과됨 : " + e.getMessage());
			//예외가 발생하면 catch블록은 위에서부터 차례대로 검사 대상이 되는데,
			//하위 예외도 상위 클래스타입 변수에 대입될 수 있기 때문에
			//마지막에 써야 한다.
		} catch(Exception e) {
			System.out.println("실행에 문제가 있습니다.");
		}
		
		
		
		
		
		
		
	}
}
