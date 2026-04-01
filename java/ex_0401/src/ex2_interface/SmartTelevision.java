package ex2_interface;

//서로 다른 인터페이스에 정의된 추상메서드를 전부 구현해야 한다.
public class SmartTelevision implements RemoteControl, Searchable {

	@Override
	public void search(String url) {
		System.out.println(url+"을 검색합니다.");
		
	}

	@Override
	public void turnOn() {
		System.out.println("스마트 티비를 켭니다.");
		
	}

	@Override
	public void setVolume(int volume) {
		
	}

}
