package ex2_system;

public class ExitExample {
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			System.out.println(i);
			if(i == 5) {
				System.out.println("프로세스 강제 종료");
				System.exit(0);//프로그램 강제 종료
				//exit는 int값을 매개값으로 필요로 한다.
				//종료 상태값으로 어떤 값을 주더라도 프로세스는 종료되는데
				//정상 종료일 경우 0, 비정상 종료는 1 또는 -1로 주는것이 관례이다.
			}
		}
	}
}
