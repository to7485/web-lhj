package ex2_interface;

public class Audio implements RemoteControl{

	int volume;
	
	@Override
	public void turnOn() {
		System.out.println("오디오를 켠다");
	}
	
	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
	}

}
