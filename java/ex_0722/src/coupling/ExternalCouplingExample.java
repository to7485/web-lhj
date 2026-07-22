package coupling;

public class ExternalCouplingExample {

	//외부에서 지정된 통신 규격 클래스
	static class ExternalConfig{
		public static final String API_PROTOCOL = "HTTPS/V1.2";
	}
	
	//1. 외부규격(ExternalConfig)이 변경되거나 수정되면 NetworkClient도 통째로 고쳐야한다.
	//2. 외부 규격/환경에 직접 의존하므로, 외부 연결 없이 이 모듈만 독립적으로 테스트하기 어려움
	//3. 시스템 외부 환경 변화에 소프트웨어가 쉽게 흔들린다.
	static class NetworkClient{
		public void connet() {
			System.out.println(ExternalConfig.API_PROTOCOL+" 통신 규격으로 연결합니다.");
		}
	}
}






