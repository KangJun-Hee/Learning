package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDAO {

	
	// 주소값 반환 받을 수 있도록 설정
	// DB연동 getConnection() 리턴타입은 Conntection() 연결 성공!
	
	private CustomerDAO() {}
	private static CustomerDAO instance = new CustomerDAO();
	public static CustomerDAO getInstance() {
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private Connection getConnection() {
		String dbURL = "jdbc:mysql://localhost:3306/onlineBook?serverTimezone=UTC&useSSL=false";
		String dbID = "root";
		String dbPassword = "1234";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 만약 비교해서 결과를 true , false로 받아서 해결 해도 됨
	// 회원 체크 하는 메서드
	public int userCheck(String id, String passwd) {
		int check = 0;
		
		return check;
	}
	
	
	
	
	
	
	
}
