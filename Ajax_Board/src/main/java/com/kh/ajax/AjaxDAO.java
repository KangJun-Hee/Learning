package com.kh.ajax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class AjaxDAO {
	//dao 싱글톤세팅
	//DB연동하는 getConnection
	private static AjaxDAO dao = new AjaxDAO();

	public static AjaxDAO getInstance() {
		return dao;
	}

	Connection conn = null;
	PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 데이터 베이스의 커넥션풀을 사용하도록 설정하는 메서드
	public Connection getConnection() {
		String dbID = "KH123";
		String dbPassword = "KH";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dbURL = "jdbc:oracle://thin:@localhost:1521:orcl";
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			System.out.println("연결성공~"+conn);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버클래스가없거나 읽어올 수 없습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
