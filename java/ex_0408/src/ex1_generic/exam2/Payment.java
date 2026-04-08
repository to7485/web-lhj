package ex1_generic.exam2;

class CardPayment implements Payment{

	@Override
	public void pay() {
		System.out.println("카드 결제");
	}
}

class KakaoPay implements Payment{

	@Override
	public void pay() {
		System.out.println("카카오페이 결제");
	}
	
}


public interface Payment {

	void pay();
}

class PaymentProcessor<T extends Payment>{
	T payment;
	
	public PaymentProcessor(T payment) {
		this.payment = payment;
	}
	
	public void process() {
		payment.pay();
	}
}






