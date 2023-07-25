package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	// LogonDBBean 전역 객체 생성 <- 한개의 객제만 생성해서 공유
	private static MemberDAO instance = new MemberDAO();
	// LogonDBBean객체를 리턴하는 메소드
	public static MemberDAO getInstance() {	return instance;}
	private MemberDAO() {}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private Connection getConnection() throws Exception {
		String dbURL = "jdbc:mysql://localhost:3306/mvc2_jq_crud?serverTimezone=UTC";
		String dbID = "root";
		String dbPassword = "root";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
		
		return conn;
	}

	// 회원 가입 처리(registerPro.jsp)에서 사용하는 새 레코드 추가 메소드
	public void insertMember(Member member) {
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("INSERT INTO member VALUES (?,?,?,now(),?,?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getTel());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null) {try {pstmt.close();} catch (SQLException ex) {}}
			if (conn != null) {try {conn.close();} catch (SQLException ex) {}}
		}
	}

	// 로그인 폼 처리(loginPro.jsp)페이지의 사용자 인증 처리 및
	// 회원정보수정/탈퇴를 사용자인증(memberCheck.jsp)에서 사용하는 메소드
	public int userCheck(String id, String passwd) {
		int x = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("SELECT passwd FROM member WHERE id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {// 해당 아이디가 있으면 수행
				String dbPasswd = rs.getString(1);
				if(passwd.equals(dbPasswd)) {
					x = 1; // 인증성공
				}else {
					x = 0;	// 패스워드 틀림
				}
			} else {// 해당 아이디 없으면 수행
				x = -1;// 아이디 없음
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {try {rs.close();} catch (SQLException ex) {}}
			if (pstmt != null) {try {pstmt.close();} catch (SQLException ex) {}}
			if (conn != null) {try {conn.close();} catch (SQLException ex) {}}
		}
		return x;
	}

	// 아이디 중복 확인 (confirmId.jsp)에서 아이디의 중복 여부를 확인하는 메소드
	public int confirmId(String id) {
		int x = -1;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select id from member where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next())// 아이디 존재
				x = 1; // 같은 아이디 있음
			else
				x = -1;// 같은 아이디 없음
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {try {rs.close();} catch (SQLException ex) {}}
			if (pstmt != null) {try {pstmt.close();} catch (SQLException ex) {}}
			if (conn != null) {try {conn.close();} catch (SQLException ex) {}}
		}
		return x;
	}

	// 회원 정보 수정 폼(modifyForm.jsp)을 위한 기존 가입 정보를 가져오는 메소드
	public Member getMember(String id, String passwd) {
		Member member = null;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select * from member where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {// 해당 아이디에 대한 레코드가 존재

				member = new Member();// 데이터저장빈 객체생성
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setReg_date(rs.getString("reg_date"));
				member.setAddress(rs.getString("address"));
				member.setTel(rs.getString("tel"));

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {try {rs.close();} catch (SQLException ex) {}}
			if (pstmt != null) {try {pstmt.close();} catch (SQLException ex) {}}
			if (conn != null) {try {conn.close();} catch (SQLException ex) {}}
		}
		return member;// 데이터 저장빈 객체 member 리턴
	}

	// 회원 정보 수정 처리(modifyPro.jsp)에서 회원 정보 수정을 처리하는 메소드
	public int updateMember(Member member) {
		int x = -1;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select passwd from member where id = ?");
			pstmt.setString(1, member.getId());
			rs = pstmt.executeQuery();

			if (rs.next()) {// 해당 아이디가 있으면 수행
				pstmt = conn.prepareStatement("update member set name=?,address=?,tel=? " + "where id=?");
				pstmt.setString(1, member.getName());
				pstmt.setString(2, member.getAddress());
				pstmt.setString(3, member.getTel());
				pstmt.setString(4, member.getId());
				pstmt.executeUpdate();
				x = 1;// 회원정보 수정 처리 성공
			} else
				x = 0;// 회원정보 수정 처리 실패

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {try {rs.close();} catch (SQLException ex) {}}
			if (pstmt != null) {try {pstmt.close();} catch (SQLException ex) {}}
			if (conn != null) {try {conn.close();} catch (SQLException ex) {}}
		}
		return x;
	}

	// 회원 탈퇴 처리(deletePro.jsp)에서 회원 정보를 삭제하는 메소드
	public int deleteMember(String id, String passwd) {
		int x = -1;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select passwd from member where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				pstmt = conn.prepareStatement("delete from member where id=?");
				pstmt.setString(1, id);
				pstmt.executeUpdate();
				x = 1;// 회원탈퇴처리 성공
			} else
				x = 0;// 회원탈퇴 처리 실패

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {try {rs.close();} catch (SQLException ex) {}}
			if (pstmt != null) {try {pstmt.close();} catch (SQLException ex) {}}
			if (conn != null) {try {conn.close();} catch (SQLException ex) {}}
		}
		return x;
	}
}