package dto;

public class BookDTO {

	private int bookId;
	private String title;
	private String author;
	private int stock;
	
	public BookDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public BookDTO(String title, String author, int stock) {
		this.title = title;
		this.author = author;
		this.stock = stock;
	}
	

	public BookDTO(int bookId, String title, String author, int stock) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.stock = stock;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	

	
	
}
