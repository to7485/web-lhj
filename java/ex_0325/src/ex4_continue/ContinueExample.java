package ex4_continue;

public class ContinueExample {
	public static void main(String[] args) {
		//for문의 경우 continue를 만나게 되면 증감식으로 이동
		for(int i = 1; i <=10;) {
			if(i % 3 == 0) {
				continue;
			}
			System.out.print(i+" ");
			i++;
		}
		
		//while, do-while의 경우 조건식으로 이동한다.
		
		
	}
}
