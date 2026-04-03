package ex1_innerclass.interfaceexample;

public class Button {

	//static 붙이지 않아도 자동으로 static 처리가 된다.
	//중첩 interface는 무조건 static이다(암묵적 static)
	public static interface ClickListener{
		void onClick(); //추상메서드
	}
	
	//필드
	private ClickListener clickListener;
	
	//setter
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
	
	//버튼이 클릭되었을 때 실행할 메서드로 click()메서드 추가하기
	//실행 내용은 ClickListener인터페이스 필드를 이용해서 onClick() 추상메서드
	//호출하기
	public void click() {
		clickListener.onClick();
	}
	
	
	
	
}
