package dto;

public class RentalDTO {
	private int rentalId;
	private int customerId;
	private int bookId;
	private String rentalDate;
	
	public RentalDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public RentalDTO(int rentalId, int customerId, int bookId, String rentalDate) {
		this.rentalId = rentalId;
		this.customerId = customerId;
		this.bookId = bookId;
		this.rentalDate = rentalDate;
	}

	public int getRentalId() {
		return rentalId;
	}

	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(String rentalDate) {
		this.rentalDate = rentalDate;
	}
	
	

	
	
	
	
	
	
	
	
	
}
