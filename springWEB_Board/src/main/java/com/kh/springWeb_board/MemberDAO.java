package com.kh.springmember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// 실제 spring에서는 Excepion -> Spring이 가지고 있는 Spring Exception으로 
// 전화하기 위해서 @Repository 사용한다. 

@Repository
public class MemberDAO {
	@Autowired // 커넥션 정보를 담고 있으며 빈으로 등록하여 인자로 넘겨준다.
	DataSource dataSource; // DB를 연결해주는 역할을 한다.

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public void finallyClose() {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				pstmt.close();
			}
			if (rs != null) {
				pstmt.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void memberJoin(Member member) {

		// 데이터베이스 연결 getConnect()
		try {

			conn = dataSource.getConnection();

			// 명령문 컴파일 하고
			// 실제 데이터들 ? 채우고
			// 쿼리 날리기!

			String sql = "INSERT INTO member (id, pw, email) VALUES(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getEmail());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			finallyClose();
		}

	}

	public int checkMember(Member member) {
		int check = -1;

		try {
			conn = dataSource.getConnection();
			// sql 명령문 작성하고 id, pw 넘기기
			String sql = "select * from member where id =? and pw= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());

			// executeQuery()
			rs = pstmt.executeQuery();

			if (rs.next()) {
				check = 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyClose();
		}

		return check;
	}

	// 회원 목록을 작성을 해야된다.
	// 회원의 전체 정보를 가지고 와야된다.
	// 데이터베이스에서!
	public ArrayList<Member> getMemberList() {

		ArrayList<Member> memberList = new ArrayList<Member>();

		try {
			conn = dataSource.getConnection();
			// sql 명령문 작성하고 id, pw 넘기기
			String sql = "select * from member order by num asc";
			pstmt = conn.prepareStatement(sql);

			// executeQuery()
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Member member = new Member();

				member.setNum(rs.getInt(1));
				member.setId(rs.getString(2));
				member.setPw(rs.getString(3));
				member.setEmail(rs.getString(4));

				memberList.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyClose();
		}

		return memberList;

	}

	public Member getOneMember(String id) {
		Member member = new Member();

		try {
			conn = dataSource.getConnection();
			// sql 명령문 작성하고 id, pw 넘기기
			String sql = "select * from member where id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());

			// executeQuery()
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member.setNum(rs.getInt(1));
				member.setId(rs.getString(2));				
				member.setPw(rs.getString(3));
				member.setEmail(rs.getString(4));;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyClose();
		}

		return member;
	}
	
	public void updateMember(Member member) {
		
		try {
			conn = dataSource.getConnection();
			// sql 명령문 작성하고 id, pw 넘기기
			String sql = "update member set pw=?,email =? where id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyClose();
		}
	}
}

// org.apache.commons.dbcp2.BasicDataSource
// DB connetion Pooling이란?
//  자바 프로그램에서 데이터베이스 연결(커넥션 객체를 얻어는 것)실행할 때마다 생성해서가져오면 오래걸림
//  일정량의 Connection객체를 미리 만들어 저장해 두었다가 요청시 꺼내쓴다. 
//  속도 , 처리 능력이 좋아 진다.

//  여러개의 커넥션 객체를 관리하는 것 커넥션 풀
//  커넥션 풀에서 사용하고 사용이 끝나면 꼭 ! 반납해야된다. 

// JDBC Template 
//  Spring JDBC 접근하는 방법 중에 하나다!
//  jdbc template을 이용해서 커넥션 연결/ 종료 와 같은 세부적인 작업을 개발자가 직접하지 않아도
//  된다. DataSource 설정 
