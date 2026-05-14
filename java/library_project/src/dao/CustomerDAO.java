package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DBUtil;
import dto.CustomerDTO;

public class CustomerDAO {

	//고객 추가 메서드
	//insertCustomer(CustomerDTO dto)
	public void insertCustomer(CustomerDTO dto) {
		String sql = "INSERT INTO customer(name,phone) values(?,?)";
		
		try(
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("고객 등록 완료");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
