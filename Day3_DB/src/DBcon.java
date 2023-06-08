import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcon {
	
	public static Connection dbConn;

	public static Connection getConnection() {

		// mysql은 버전 상관없어요! 
		// 오라클 버전 중요하게 생각한다. 
		// Oracle version 이랑 jdk version 호환성
		
		Connection con = null;    
		try {
			String user = "system";
			String pw  = "1234";
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			
			//jdbc:oracle:thin
			// 오라클에 접속하겠다고 알려줌
			
			// 내 ip 주소
			// @localhost
			
//			포트 번호  -> 1521 
			//접속할 DB 이름 orcl		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// JDBC 드라이버(ojdbc6~8.jar)를 로딩하는 부분이다.
			// 로딩 실패 classNotFoundException 
			
			con = DriverManager.getConnection(url, user, pw);
			
			System.out.println("연결");
		
		}catch(ClassNotFoundException e) {
			System.out.println("데이터베이스 연결 에러!" + e.toString());
		}catch(SQLException e) {
			System.out.println("DB접속 실패 :"+ e.toString());
		}		
		
		return con;
	}
}
