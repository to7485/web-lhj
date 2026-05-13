package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Select {
	public static void main(String[] args) {
		//db접속 경로
				//형식
				//jdbc:mysql://서버주소:포트번호/데이터베이스명
				String url = "jdbc:mysql://localhost:3306/java_db";
				String user = "root";
				String password = "11111111";
				
				//select,insert,update,delete
				//실행할 sql을 작성
				//?는 값이 들어갈 자리(placeholder)
				String sql = "select * from member";
				
				
			try(	
				//MySQL 서버와 실제 연결을 생성한다.
				Connection conn = DriverManager.getConnection(
				url,
				user, 
				password);
				
				//SQL을 안전하고 효율적으로 실행하기 위한 객체
				PreparedStatement pstmt = conn.prepareStatement(sql);
					
				//sql문 실행결과를 rs에 담는다.
				ResultSet rs = pstmt.executeQuery();
				) {
					
					//연결 성공시
					System.out.println("MySQL 연결 성공");
					
					
					
					//rs.next() : 다음 행으로 이동
					while(rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String email = rs.getString("email");
						int age = rs.getInt("age");
						
						System.out.printf(" id : %d name : %s email : %s age : %d\n",id,name,email,age);
					}
					
					
				} catch (Exception e) {
					System.out.println("연결 실패");
					e.printStackTrace();
				}
	}
}
