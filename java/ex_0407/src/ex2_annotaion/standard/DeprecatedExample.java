package ex2_annotaion.standard;

public class DeprecatedExample {
	
	@Deprecated //더 이상 사용을 권장하지 않는 기능에 붙인다.
	public static void oldMethod() {
		System.out.println("오래된 메서드");
	}
	
	public static void main(String[] args) {
		oldMethod();
	}
}
