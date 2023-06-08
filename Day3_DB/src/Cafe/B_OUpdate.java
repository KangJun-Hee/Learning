package Cafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class B_OUpdate {

	public static void main(String[] args) {
		String user = "system";
		String pw = "1234";
		String url = "jdbc:oracle.thin:@localhost:1521:xe";
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		Connection con = null;
		
		PreparedStatement pstm = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(user,pw,url);
			System.out.println("연결성공~");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("음료 이름을 입력하세요:");
			String num = sc.nextLine();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("음료 이름을 입력하세요:");
			String num = sc.nextLine();
		} catch (Exception e) {

		}
	}

}
