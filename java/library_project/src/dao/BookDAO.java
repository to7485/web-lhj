package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBUtil;
import dto.BookDTO;

public class BookDAO {

	//book 테이블에 도서 정보를 등록하는 기능 구현하기
	//insertBook(BookDTO dto)
	public void insertBook(BookDTO dto) {
		//db에 요청하려는 쿼리문
		String sql = "INSERT INTO book(title,author,stock) values (?,?,?)";
		
		try (
			//db연결하기
			//1. 연결객체 필요하다.(어디로 접속, 계정, 비밀번호)
			Connection conn = DBUtil.getConnection();
			//2. 문자열 형태의 쿼리문을 db로 전송할 수 있도록 가공
			PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getAuthor());
			pstmt.setInt(3, dto.getStock());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("도서 등록 완료");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//전체 도서 조회 기능 만들기
	//findAllBooks()
	public void findAllBooks() {
		String sql = "SELECT * FROM book";
		
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
				){
			while(rs.next()) {
				int bookId = rs.getInt("book_id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				int stock = rs.getInt("stock");
				
				System.out.println("도서번호 : " + bookId);
				System.out.println("도서명 : " + title);
				System.out.println("저자 : " + author);
				System.out.println("재고 : " + stock);
				System.out.println("---------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void findLowStockBooks() {
		
		String sql = "select * from book where stock <= 2";
		List<BookDTO> list = new ArrayList<>();
		
		try (
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();	
		){
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setBookId(rs.getInt("book_id"));
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("Author"));
				dto.setStock(rs.getInt("stock"));
				
				list.add(dto);
				
				System.out.println("도서번호 : " + dto.getBookId());
				System.out.println("도서명 : " + dto.getTitle());
				System.out.println("저자 : "+ dto.getAuthor());
				System.out.println("재고 : " + dto.getStock());
				System.out.println("----------------");
			}
			
			if(list.isEmpty()) {
				System.out.println("재고가 충분합니다.");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
