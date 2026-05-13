package common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	//db접속 정보
	//주소
	private static String url = "jdbc:mysql://localhost:3306/java_db";
	//아이디
	private static String user = "root";
	//비밀번호
	private static String password = "11111111";
	
	
	//데이터베이스 연결 객체를 반환하는 메서드
	public static Connection getConnection() {
		//연결에 성공하면 connection 객체를 반환
		try{
			Connection conn = DriverManager.getConnection(url,user,password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		//실패하면 null을 반환하기
		return null;
	}
	
	
	
	
	
	
	
	
	
	
}
