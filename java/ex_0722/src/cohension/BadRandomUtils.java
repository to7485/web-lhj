package cohension;

//우연적응집도
//연관성이 전혀 엇는 코드들이 무작위로 모여있는것
//- 모듈화로서의 장점이 전혀 없음
//- 코드를 수정해야 할 때 어디서 어떤 부작용이 터질지 예측할 수 없음
//- 가독성이 최악이며, 단위 테스트 작성이 매우 곤란함
//- 코드의 중복과 혼란을 극대화하여 유지보수 비용을 폭증시킴
public class BadRandomUtils {
	
	public void doRandomThings() {
		calculateTax();
		playAlramSound();
		checkPrinterPaper();
	}

	private void calculateTax() {
		// TODO Auto-generated method stub
		
	}

	private void playAlramSound() {
		// TODO Auto-generated method stub
		
	}

	private void checkPrinterPaper() {
		// TODO Auto-generated method stub
		
	}

}
