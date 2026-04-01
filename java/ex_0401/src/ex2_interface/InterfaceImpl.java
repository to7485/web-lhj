package ex2_interface;

public class InterfaceImpl implements InterfaceC{

	@Override
	public void methodA() {
		System.out.println("구현체 methodA 실행"); 
	}

	@Override
	public void methodB() {
		System.out.println("구현체 methodB 실행");
	}

	@Override
	public void methodC() {
		System.out.println("구현체 methodC 실행");
	}

}
