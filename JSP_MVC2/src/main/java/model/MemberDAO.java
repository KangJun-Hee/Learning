package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// db연동
	private Connection getConnection() {
		String dbURL = "jdbc:mysql://localhost:3306/joinmvcdb04?serverTimezone=UTC&useSSL=false";
		String dbID = "root";
		String dbPassword = "1234";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// id중복체크

	// 회원가입

	// 로그인
	public int loginCheck(String id, String pw) {

		int check = -1;

		try {
			conn = getConnection();
			String sql = "select pw from member where id=?";
			// 쿼리문을 실행을 위한 객체 (pstmt)생성
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String dbPw = rs.getString("pw");
				if (dbPw.equals(pw)) {
					check = 1;
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			// e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
					pstmt.close();
					rs.close();
				} catch (SQLException e) {
				}
			}
		}

		return check;
	}

	// 화면 정보 꺼내오기 (한명의 정보)
	public MemberBean getOneMember(String id) {
		MemberBean bean = null;

		try {
			conn = getConnection();
			String sql = "select * from member where id=?";
			// 쿼리문을 실행을 위한 객체 (pstmt)생성
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				String field = rs.getString("field");
				String skill = rs.getString("skill");
				String major = rs.getString("major");

				bean = new MemberBean(id, pw, name, tel, email, field, skill, major);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			// e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
					pstmt.close();
					rs.close();
				} catch (SQLException e) {
				}
			}
		}

		return bean;
	}

	// 입사지원 하기 apply
	public void apply(String id, String field, String skill, String major) {
		try {
			conn = getConnection();
			String sql = "update member set field=?,skill=?,major=?";
			sql += "where id=?";
			// 쿼리문을 실행을 위한 객체 (pstmt)생성
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, field);
			pstmt.setString(2, skill);
			pstmt.setString(3, major);
			pstmt.setString(4, id);

		} catch (Exception e) {
			System.out.println(e.toString());
			// e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
					pstmt.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	// 회원정보 수정
	public void updateMember(String id, MemberBean bean) {
		try {
			conn = getConnection();
			String sql = "update member set field=?,skill=?,major=?,";
				   sql+="pw=?,name=?,tel=?,email=?";
			       sql += "where id=?";
			// 쿼리문을 실행을 위한 객체 (pstmt)생성
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bean.getField());
			pstmt.setString(2, bean.getSkill());
			pstmt.setString(3, bean.getMajor());
			pstmt.setString(4, bean.getPw());
			pstmt.setString(5, bean.getName());
			pstmt.setString(6, bean.getTel());
			pstmt.setString(7, bean.getEmail());
			pstmt.setString(8, bean.getId());


		} catch (Exception e) {
			System.out.println(e.toString());
			// e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
					pstmt.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	// 탈퇴하기
	public void delete(String id) {

		try {
			conn = getConnection();
			String sql = "delete from member where id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.toString());
			// e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
					pstmt.close();
					rs.close();
				} catch (SQLException e) {
				}
			}
		}

	}
}
