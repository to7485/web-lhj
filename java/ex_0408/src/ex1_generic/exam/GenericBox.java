package ex1_generic.exam;

//제네릭타입 T를 사용하는 클래스
//item 필드 1개를 가진다. 타입은 T
//setter로 값을 지정한다.
//getter로 메서드값을 반환한다.
//Main에서 GenericBox<String>객체에게 "사과"저장후 출력
//GenericBox<Integer> 객체에 100 저장후 출력

public class GenericBox<T> {
	
	private T item;
	
	//item의 값을 저장하는 setter
	public void setItem(T item) {
		this.item = item;
	}
	
	//item의 값을 반환하는 getter
	public T getItem() {
		return item;
	}

}
