package ex1_exception.customException;


public class OrderService {

	//총 금액 계산
	public int calculateTotal(int price, int quantity) throws IllegalArgumentException{
		if(price < 0) {
			throw new IllegalArgumentException("가격은 1이상이어야 합니다.");
		}
		
		if(quantity <= 0) {
			throw new IllegalArgumentException("수량은 1이상이어야 합니다.");
		}
		
		return price * quantity;
	}
}
