package ex3_generic.exam;


//여기서 T는 값을 담아주는게 아님
//타입자리를 대신할 문자
public class Box<T> {
	private T item;
	
	public void setItem(T item) {
		this.item = item;
	}
	
	public T getItem() {
		return item;
	}
	
	//제네릭 메서드
	//메서드에만 적용되는 제네릭 타입을 따로 두는것
	//제네릭클래스가 아니어도 제네릭 메서드를 만들 수 있다.
	public <U> void print(U value) {
		System.out.println(value);
	}
	
	
	
	
	
	
	
}
