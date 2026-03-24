package ex3_switch;

public class SwitchExample {
	public static void main(String[] args) {
		int num = 2;
		
		switch(num) {
		case 1:
			System.out.println("1이 나왔습니다.");
			break;
		case 2:
			System.out.println("2가 나왔습니다.");
			break;
		case 3:
			System.out.println("3이 나왔습니다.");
			break;
		default:
			System.out.println("일치하는 조건값이 없습니다.");
			break;
		}
		
		char ch = 'B';
		
		switch(ch) {
		case 'A':
			System.out.println("A입니다.");
			break;
		case 'B':
			System.out.println("B입니다.");
			break;
		case 'C':
			System.out.println("C입니다.");
			break;
		}
		
		//실수타입은 비교값으로 작성할 수 없다!!
		
		String s = "홍";
		
		switch(s) {
		case "김":
			System.out.println("김길동");
			break;
		case "이":
			System.out.println("이길동");
			break;
		case "박":
			System.out.println("박길동");
			break;
		default:
			System.out.println("일치하는 이름이 없음");
			break;
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}






