package ex2_super_method;

public class Main {
	public static void main(String[] args) {
		//초음속비행기 객체 생성하기
		SuperSonicAirplane sa = new SuperSonicAirplane();
		//takeOff() 메서드 호출하기
		sa.takeOff();
		//fly()메서드 호출하기
		sa.fly();
		//비행모드를 초음속으로 바꾸기
		sa.flyMode = SuperSonicAirplane.SUPERSONIC;
		//fly()메서드 호출해서 확인하기
		sa.fly();
		//비행모드를 노말로 바꾸기
		sa.flyMode = SuperSonicAirplane.NORMAL;
		//fly()메서드 호출해서 확인하기
		sa.fly();
		//착륙하기
		sa.land();
	}
}
