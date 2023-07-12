package com.kh.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public RegisterDAO(){
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			conn = DriverManager.getConnection(url, "KH123", "KH");
			
			System.out.println("연결성공: " + conn);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스가 없거나 읽어올 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 정보가 올바르지 않습니다.");
		}		
	}
	
	// index.jsp에 입력한 회원정보를 저장하는 메서드 
	public int register(RegisterDTO vo) {
		System.out.println("RegisterDAO register()메서드 실행");
		
		try {
			
			String sql = "insert into register (userID, userPassword, userName, userAge, userGender, userEmail) "
					+ "values (?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserID());
			pstmt.setString(2, vo.getUserPassword());
			pstmt.setString(3, vo.getUserName());
			pstmt.setInt(4, vo.getUserAge());
			pstmt.setString(5, vo.getUserGender());
			pstmt.setString(6, vo.getUserEmail());
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {		
			System.out.println("중복되는 아이디가 입력되었습니다.");
		} 
		
		return 0;  // 만약 예외발생해서 return 값을 돌려줘야될 때는 본인이 설정한 값을 넘겨주기		
	}

	//가입할 아이디가 DB에 잇는지 확인 메서드~~
	public int registerCheck(String userID) {
		System.out.println("RegisterDAO의 registerCheck()메서드 실행~");
		
		try {
			//varchar2(60) 10개 밖에 안 된다~
			//char (20) 5개만 입력하면 나머진 공백처리 됨
														//공백제거
			String sql = "select * from register where trim(userID) = ? ";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,userID);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//사용중인 아이디일 경우
				return 2;
			}else if(userID.trim().equals("")) {
				//중복검사할 아이디를 입력하지 않고 중복체크버튼 클릭한경우
				return 1;//숫자 걍 정한거임
			}else {
				//사용가능한 아이디일 경우
				return 3;
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
