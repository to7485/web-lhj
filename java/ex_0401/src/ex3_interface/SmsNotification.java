package ex3_interface;

public class SmsNotification implements Notification{

	@Override
	public void send(String message) {
		System.out.println("[SMS] "+message+"를 전송합니다.");
	}
}
