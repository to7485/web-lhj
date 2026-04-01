package ex4_setter_getter;

//프로그램을 실행하는 구간
public class Main {
	public static void main(String[] args) {
		//객체를 만들어야 함
		//new 클래스명();
		Student s = new Student();
		
		s.setName("홍길동");
		s.setAge(30);
		System.out.println("이름 : " + s.getName());
		System.out.println("나이 : " + s.getAge());
		
		User user = new User();
		
		user.setUsername("김이박길동");
		user.setPassword("1234567");
		user.setEmail("aaa@gmail.aaa");
		
		user.userInfo();
//		System.out.println(user.getUsername());
//		System.out.println(user.getPassword());
//		System.out.println(user.getEmail());
		
		
		
		
		
		
		
	}
}
