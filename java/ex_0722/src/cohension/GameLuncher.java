package cohension;

//절차적응집도
//데이터 연관성보다는 정해진 실행 순서를 지키는 것이 목적인 경우
public class GameLuncher {

	public void launchGame() {
		showLodingScreen();
		loadingGameData();
		displayMainMap();
	}
	
	private void showLodingScreen() {
		System.out.println("1. 로딩 화면을 표시합니다.");
	}
	
	private void loadingGameData() {
		System.out.println("2. 캐릭터 데이터를 불러옵니다.");
	}
	
	private void displayMainMap() {
		System.out.println("3. 메인 게임 화면을 출력합니다.");
	}
	
	
	
	
	
	
	
}
