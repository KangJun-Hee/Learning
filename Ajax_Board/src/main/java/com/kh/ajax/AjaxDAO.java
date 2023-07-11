package com.kh.ajax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AjaxDAO {
	
	// dao 싱글톤 세팅 
	// 데이터베이스 연동 getConnection();
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public AjaxDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "system", "1234");
			// System.out.println("연결성공: " + conn);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스가 없거나 읽어올 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 정보가 올바르지 않습니다.");
		}
	}
	
	
//	검색어로 입력된 문자열이 name 필들에 포함된 데이터만 얻어오는 메소드
	public ArrayList<AjaxDTO> search(String name) {
		System.out.println("AjaxDAO 클래스의 search() 메소드");
		ArrayList<AjaxDTO> list = new ArrayList<>();
		
		try {
			String sql = "select * from ajax where name like ? order by idx desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%' + name + '%');
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				AjaxDTO vo = new AjaxDTO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setEmail(rs.getString("email"));
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

//	index.jsp에서 입력한 데이터를 테이블에 저장하는 메소드
	public int insert(AjaxDTO vo) {
		System.out.println("AjaxDAO 클래스의 insert() 메소드");
		
		try {
			String sql = "insert into ajax (idx, name, age, gender, email) values (ajax_idx_seq.nextval, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getEmail());
			
			return pstmt.executeUpdate(); // sql 명령이 정상적으로 실행된 개수를 리턴한다.
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// sql 명령에 오류가 있어서 catch 블록이 실행되면 -1을 리턴한다.
		return -1;
	}	
}
