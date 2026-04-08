package ex3_generic.exam;

public class MemberResponse<T> {
	boolean success;
	String message;
	T data;
	
	public MemberResponse(boolean success, String message, T data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public String getMessage() {
		return message;
	}
	
	public T getData() {
		return data;
	}
	
	
	
}
