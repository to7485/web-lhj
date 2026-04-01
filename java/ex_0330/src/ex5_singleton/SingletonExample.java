package ex5_singleton;

import java.util.Calendar;

public class SingletonExample {
	public static void main(String[] args) {
		//생성자가 private으로 정의되어 있기 때문에
		//다른 클래스에서 호출하는게 불가능하다.
		//Singleton obj = new Singleton();
		
		//Singleton클래스에서 만들어놨던 객체를 받아온것
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		//obj1과 obj2가 같은 객체인지 증명하기
		//같은 객체면 "같은 객체입니다."
		//아니면 "같은 객체가 아닙니다."
		if(obj1 == obj2) {
			System.out.println("같은 객체입니다.");
		} else {
			System.out.println("다른 객체입니다.");
		}
		
		System.out.println(obj1);
		System.out.println(obj2);
		
		AttendanceManager a1 = AttendanceManager.getInstance();
		AttendanceManager a2 = AttendanceManager.getInstance();
		
		a1.addAttendance();
		a2.addAttendance();
		
		System.out.println(a1.getAttendance());
		System.out.println(a2.getAttendance());
		
		//싱글톤 패턴을 사용하는 이유
		//공유 자원을 효율적으로 관리하고, 구조를 안정적으로 유지하기 위해서
		//new 생성자(); 를 통해서 객체를 여러개 만들게 되면 메모리를 많이 사용한다.
		
		//어디서든지 같은 객체를 가져올 수 있다.
		
		//데이터를 일관성있게 유지할 수 있다.
		
		//실무에서 많이 쓰는 대표적인 사례
		
		//1. DB연결 관리자
		//2. 로그시스템 -> 하나의 객체로 기록
		//3. 설정(Config) -> 모든 곳에서 동일한 값을 가진다.
		
		Calendar cal = Calendar.getInstance();
		
		
		
		
	}
}
