package ex1_List.ArrayList.product;

import java.util.ArrayList;
import java.util.List;

//장바구니 기능들을 구현
public class Cart {
	
	private List<Product> products = new ArrayList<>();
	
	//상품추가(같은 상품이 들어오면 수량만 증가)
	public void addProduct(String name, int price, int quantity) {
		//list의 size()가 0이면 반복문을 안들어간다.
		for(Product p : products) {
			if(p.getName().equals(name)) {
				p.setQuantity(p.getQuantity()+ quantity);
				System.out.println("기존 상품 수량 증가 완료");
				return;
			}
		}
		
		//넘어온 제품이 겹치지 않는다면 list에 추가하기
		products.add(new Product(name,price,quantity));
		System.out.println("상품 추가 완료");
	}
	
	
	
	
	
	
	

}
