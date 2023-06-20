package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	// mysql에 연결하는 connection을 리턴하는 메서드
	public static Connection getMysqlConnection() {
		
		Connection conn = null;
		
		// 라이브러리 8버전 가져오기 추가 
		// 드라이버 만들어서 가지고 오고 url 연결 해서 연결 성공 !
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			String url = "jdbc:mysql://localhost:3306/memolists?serverTimezone=UTC"; // 8.x 사용자
			conn = DriverManager.getConnection(url, "root", "1234");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스가 없거나 읽어올 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("데이터베이스 접속 정보가 올바르지 않습니다.");
		}
				
		return conn;		
	}
	
	public static void close(Connection conn) {
		if( conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}
