package ex3_interface;

//물리적 버튼
public class Button {

	ClickListener clickListener;
	
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
	
	public void click() {
		clickListener.onClick();
	}
}
