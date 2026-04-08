package ex1_generic.exam2;

public class Main {
	public static void main(String[] args) {
		PaymentProcessor<CardPayment> p1 = new PaymentProcessor<>(new CardPayment());
		p1.process();
		
		PaymentProcessor<KakaoPay> p2 = new PaymentProcessor<>(new KakaoPay());
		p2.process();
	}
}
