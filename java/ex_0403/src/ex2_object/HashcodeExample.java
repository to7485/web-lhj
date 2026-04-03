package ex2_object;

public class HashcodeExample {
	public static void main(String[] args) {
		Student s1 = new Student(1, "홍길동");
		Student s2 = new Student(1, "홍길동");
		
		//해시코드가 같은지 검사
		
		//문자열은 내용이 같으면 항상 동일한 해시코드값을 반환한다.
		System.out.println(s1.hashCode() == s2.hashCode());
		
		
	}
}
