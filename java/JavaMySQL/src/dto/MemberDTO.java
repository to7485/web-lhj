package dto;

//DTO(Data Transfer Object)
//쿼리결과 얻어온 데이터를 저장할 객체
public class MemberDTO {
	private int id;
	private String name;
	private String email;
	private int age;
	

	public MemberDTO(String name, String email, int age) {
		this.name = name;
		this.email = email;
		this.age = age;
	}
	
	//모든 필드를 매개변수로 갖는 생성자 만들기
	public MemberDTO(int id, String name, String email, int age) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
	
	
	
}
