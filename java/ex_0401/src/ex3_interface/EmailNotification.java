package ex3_interface;

public class EmailNotification implements Notification{

	@Override
	public void send(String message) {
		System.out.println("[EMAIL] "+message+"를 환영합니다.");
	}
}
