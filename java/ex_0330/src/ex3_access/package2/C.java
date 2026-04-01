package ex3_access.package2;

//package1에 있는 모든 클래스를 가져와서 쓰겠다.
import ex3_access.package1.*;

public class C {
	//A a; x -> default로 선언되어 있기 때문에 다른 패키지에서 접근이 안됨
	B b; //O
}
