package ex2_charstream.exam;

public class User {

	private String id;
	private String password;
	
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public byte[] toByteData() {
		String data = id+ ":"+password+"\n";
		return data.getBytes();
	}
	
	public String getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	
	
}
