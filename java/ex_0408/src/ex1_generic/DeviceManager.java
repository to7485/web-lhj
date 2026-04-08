package ex1_generic;

//RemoteControl 인터페이스를 구현한 타입만 들어올 수 있다.
public class DeviceManager<T extends RemoteControl>{
	
	private T device;
	
	public DeviceManager(T device) {
		this.device = device;
	}
	
	public void powerOn() {
		device.turnOn();
	}

}
