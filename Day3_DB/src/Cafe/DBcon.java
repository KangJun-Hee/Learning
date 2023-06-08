package Cafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcon {

	public static Connection dbCon;

	public static Connection getConnection() {
		Connection con = null;
		try {
			String user = "system";
			String pw = "1234";
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection(url,user,pw);
			System.out.println("연결");
			
		} catch (ClassNotFoundException e) {
			System.out.println("데이터베이스 연결 에러!"+e.toString());
		} catch (SQLException e) {
			System.out.println("DB접속 실패:"+e.toString());
		}
		return con;
	}

}
