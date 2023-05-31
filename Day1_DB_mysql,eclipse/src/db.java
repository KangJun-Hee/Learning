import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db
{

	public static void main(String[] args) {
		
		//JDBC 드라이버 클래스 
		// - DB의 드라이버 클래스 네임, 연결 하기 위해서
		//  사용한다. 
		//  class.forname() 메서드를 이용해서 JDBC 드라이버를 로딩 
		
		//  오라클 
		// -  Class.forName("oracle.jdbc.driver.OracleDriver");
		// - 포트 번호 기본적으로 1521
		// 5.x
		//  Class.forName("com.mysql.jdbc.Driver");
		
		
		try {// 8.X
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/pos?serverTimezone=UTC";
			String user = "root";
			String pass = "1234";
			
			// 데이터베이스 실제 연결을 도와주는 클래스 
			
			Connection con = DriverManager.getConnection(url, user, pass);
			
			if(con != null) {
				System.out.println("DB연결 성공!");
			}
			
		
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스가 없거나 읽어올 수 없습니다.");
			e.printStackTrace();
		
		} catch (SQLException e) {
			System.out.println("데이터베이스 접속 정보가 올바르지 않습니다.");
			e.printStackTrace();
		}
		
				
	}
	// 데이터베이스 작업에 사용한 객체를 닫는 메서드 
	
	public static void close(Connection conn) {
		if(conn != null) {
			try {	conn.close();  } 
			catch (SQLException e) {e.printStackTrace();}
		}				
	}
	
	public static void close(Statement conn) {
		if(conn != null) {
			try {	conn.close();  } 
			catch (SQLException e) {e.printStackTrace();}
		}				
	}
	public static void close(PreparedStatement conn) {
		if(conn != null) {
			try {	conn.close();  } 
			catch (SQLException e) {e.printStackTrace();}
		}				
	}
	public static void close(ResultSet rs) {
		if (rs != null) {
		try { rs.close(); } 
		catch (SQLException e) { e.printStackTrace(); } }
	}
	
	
}