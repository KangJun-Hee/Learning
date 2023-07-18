package com.kh.springWeb_board.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	DataSource dataSource;

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

	public int getAllCount() {
		int count = 0;
		try {
			conn = dataSource.getConnection();

			String sql = "select count(*) from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finallyClose();
		}
		return count;
	}

	// 전체 게시글 가져오기!
	public ArrayList<Board> getAllBoard(int start, int count) {
		
		ArrayList<Board> list = new ArrayList<Board>();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT * FROM board ORDR BY ref desc, re_level"
					
			pstmt.setInt(1,start);
			pstmt.setInt(2,);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Board bean = new Board();

				bean.setNum(rs.getInt(1));
				bean.setWriter(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setSubject(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setReg_date(rs.getDate(6).toString());
				bean.setRef(rs.getInt(7));
				bean.setRe_step(rs.getInt(8));
				bean.setRe_level(rs.getInt(9));
				bean.setReadcount(rs.getInt(10));
				bean.setContent(rs.getString(11));

				
				list.add(bean);//리스트 꼭 추가하기~
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyClose();
		}
		
		return list;//DB에서 꺼낸 데이터 객체에 저장해 돌려준다
	}

	public void insertBoard(Board board) {
		// 추가하긴 추가하는데
		int ref = 0;

		try {
			conn = dataSource.getConnection();

			String refSql = "SELECT MAX(ref) FROM board";
			pstmt = conn.prepareStatement(refSql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				ref = rs.getInt(1) + 1;
			}

			String sql = "INSERT INTO board (writer, email, subject, " + "password, reg_date, ref, re_step, re_level, "
					+ "readcount, content) VALUES(?, ?, ?, ?, now(), ?, 1, 1, 0, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getEmail());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getPassword());
			pstmt.setInt(5, ref);
			pstmt.setString(6, board.getContent());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finallyClose();
		}

	}

	public Board getOneBoard(int num) {
		// TODO Auto-generated method stub
		return null;
	}

}