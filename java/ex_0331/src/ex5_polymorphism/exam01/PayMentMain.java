package ex5_polymorphism.exam01;

class Payment{
	public void pay(int amount) {
		System.out.println(amount+"원을 결제합니다.");
	}
}

class CardPayment extends Payment{
	@Override
	public void pay(int amount) {
		System.out.println("카드로 " + amount+"원을 결제합니다.");
	}
}

class KakaoPayment extends Payment{
	@Override
	public void pay(int amount) {
		System.out.println("카카오페이로 " + amount+"원을 결제합니다.");
	}
}

class Order{
	Payment payment;
	
	public void proccessPayment(int amount) {
		payment.pay(amount);
	}
}

public class PayMentMain {
	public static void main(String[] args) {
		Order order = new Order();
		order.payment =new CardPayment();
		order.proccessPayment(50000);
		
		order.payment = new KakaoPayment();
		order.proccessPayment(30000);
	}
}





