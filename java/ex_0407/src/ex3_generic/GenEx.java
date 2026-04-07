package ex3_generic;

//클래스에 제네릭 타입을 설정

public class GenEx<T> {

	//제네릭 타입의 변수 value;
	T value;
	//value값을 반환하는 getValue();
	public T getValue() {
		return value;
	}
	//value값을 세팅하는 setValue();
	public void setValue(T value) {
		this.value = value;
	}
	
	
	
	
	
	
	
}
