package ex1_generic;

public class Audio implements RemoteControl{

	@Override
	public void turnOn() {
		System.out.println("Audio 전원 켬");
	}

}
