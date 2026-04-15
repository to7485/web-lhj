package ex3_collection.exam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

//상품관리 기능들이 모여있는 클래스
public class ProductService {

	//제품을 담기 위한 리스트
	private List<Product> productList = new ArrayList<>();
	
	//제품 추가하기
	public void addProduct(Product product) {
		//제품코드가 같으면 추가하면 안된다.
		if(findByCode(product.getCode()) != null) {
			System.out.println("이미 존재하는 상품 코드입니다.");
			return;
		}
		
		//겹치는 상품이 없다면 리스트에 추가하기
		productList.add(product);
	}
	
	//전체 상품 출력하기
	public void printAllProducts() {
		System.out.println("===전체 상품 목록===");
		for(Product p : productList) {
			System.out.println(p);//오버라이딩 된 toString()메서드가 같이 실행
		}
	}
	
	
	//제품코드를 통해 제품을 찾는 메서드
	public Product findByCode(String code) {
		for(Product p : productList) {
			if(p.getCode().equals(code)) {
				return p;
			}
		}
		
		return null; //if문에 못들어갈수도 있으니 바깥에 return을 써줌
	}
	
	//상품 정보의 수정
	public void updateProduct(String code, Consumer<Product> updater) {
		//코드에 해당하는 제품 한 개 찾기
		Product p = findByCode(code);
		
		if(p == null) {
			System.out.println("상품이 존재하지 않습니다.");
			return;
		}
		
		//넘어온 람다식을 실행
		updater.accept(p);
	}
	
	public void findProductsByCondition(Predicate<Product> predicate) {
		System.out.println("===재고 있는 상품===");
		//전체 순회하면서
		for(Product p : productList) {
			//매개변수로 넘어온 람다식의 조건에 맞으면
			if(predicate.test(p)) {
				System.out.println(p);
			}
		}
	}
	
	//조건에 맞는 제품 삭제하기
	public void deleteProductsByCondition(Predicate<Product> predicate) {
		Iterator<Product> iter = productList.iterator();
		
		//remove(Object o) : 일치하는 첫번째를 삭제
		
		while(iter.hasNext()) {
			Product p = iter.next();
			if(predicate.test(p)) {
				//어떤 제품이 몇번 index에 들어있는 파악하기 힘들기 때문에 iterator를 사용
				iter.remove();
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
