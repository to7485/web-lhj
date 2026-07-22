package cohension;

//논리적응집도
//- 하나의 메서드/클래스가 너무 많은 역할을 맡게된다.
//- 새로운 기능이 추가될 때마다 기존 조건문을 계속 수정해야 한다.
//- 호출하는 쪽에서 내부 작동 방식을 잘 알고 파라미터를 정확히 넘겨야 한다.
public class PrinterManager {

	//'프린터 처리'라는 논리적 그룹으로 묶여있으나
	//if-else 조건문에 따라서 완전히 다른 일을 선택해서 실행한다.
	public void processPrinterCommand(String command) {
		if(command.equals("PRINT")) {
			printDocument();
		} else if(command.equals("SCAN")) {
			scanDocument();
		} else if(command.equals("CANCEL")) {
			cancelTask();
		}
	}

	private void printDocument() {
		System.out.println("문서를 인쇄한다.");
	}

	private void scanDocument() {
		System.out.println("문서를 스캔한다.");
	}

	private void cancelTask() {
		System.out.println("작업을 취소한다.");
	}


}
