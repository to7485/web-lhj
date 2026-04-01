package ex3_access.package1;

public class D {
	
	D d1 = new D(true);
	D d2 = new D(1);
	D d3 = new D("문자열");
	
	//public 접근제한 생성자 선언
	public D(boolean b) {
		
	}
	//default 접근제한 생성자 선언
	D(int b){
		
	}
	
	//private 접근제한 생성자 선언
	private D(String s) {
		
	}

}
