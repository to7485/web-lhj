package db;

import java.sql.Connection;
import java.sql.DriverManager;

//db 연결 하기
public class DBUtil {

	//접속경로
	private static final String URL = "jdbc:mysql://localhost:3306/rental_db";
	//아이디
	private static final String USER = "root";
	//비밀번호
	private static final String PASSWORD = "11111111";
	
	//연결 객체를 반환하는 메서드
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}
	
	
	
	
	
	
}
