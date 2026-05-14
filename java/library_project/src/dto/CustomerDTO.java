package dto;

public class CustomerDTO {

	private int customerId;
	private String name;
	private String phone;
	
	public CustomerDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerDTO(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public CustomerDTO(int customerId, String name, String phone) {
		this.customerId = customerId;
		this.name = name;
		this.phone = phone;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
}
