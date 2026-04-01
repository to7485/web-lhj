package ex1_abstract;

public class StorePickup extends Delivery{

	@Override
	public void ship() {
		System.out.println("매장픽업");
	}

}
