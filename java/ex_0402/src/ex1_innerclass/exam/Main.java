package ex1_innerclass.exam;

public class Main {
	public static void main(String[] args) {
		RemoteControl rc = new RemoteControl();
		RemoteControl.Button button = rc.new Button();
		
		button.press();
		System.out.println("현재 전원 상태 : " + rc.power);
		
		Calculator result = new Calculator();
		Calculator.Result result2 = result.add(10, 20);
		
		result2.show();
	}
}
