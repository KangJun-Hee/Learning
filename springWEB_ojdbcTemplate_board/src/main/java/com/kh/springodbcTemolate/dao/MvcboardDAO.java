package com.kh.springodbcTemolate.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.kh.springodbcTemolate.Constant;
import com.kh.springodbcTemolate.vo.MvcboardVO;

public class MvcboardDAO {

	private static final Logger logger = LoggerFactory.getLogger(MvcboardDAO.class);
	
	// JdbcTemplate 설정
	private JdbcTemplate template;
	
	// DAO 클래스의 bean이 기본 생성자로 생성되는 순간 servlet-context.xml
	// 파일에서 생성되서 컨트롤러가 전달받아 Constant 클래스의  JdbcTemplate 클래스 타입의
	// static 객체에 저장한 bean으로 초기화 시킨다.
	
	public MvcboardDAO() {
		template = Constant.template;
	}
	
	// 밑에 있는DBCP 방식을 사용하는 객체를 초기화는 부분이므로 JdbcTemplate
	// 으로 코드 변환이 완려되면 모두 주석처리 한다.
	
//	private DataSource dataSource;
//	
//	public MvcboardDAO() {
//		try {
//			Context context = new InitialContext();
//			dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/oracle");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}
//============================================================================	
	
// insert, delete, update sql 명령을 실행하는 메서드의 인수로 넘어온 데이터가 
// 중간에 값이 변경되면 안되기 때문에 JdbcTemplate에서는 insert, delete
// update sql 명령을 실행하는 메서드의 인수를 선언 할 때 final을 붙여서 넘어온 
// 데이터를 수정할 수 없도록 선언해야 한다. 
	
	public void insert(final MvcboardVO mvcboardVO) {
		
		logger.info("insert()");
		
		String sql = "insert into mvcboard (idx, name, subject, content, gup, lev, seq) " + 
				"values (mvcboard_idx_seq.nextval, ?, ?, ?, mvcboard_idx_seq.currval, 0, 0)";
		
			
		template.update(sql, new PreparedStatementSetter() {
			// PreparedStatementSetter 인터페이스 객체를 익명으로 구현하는 setValues()추상메서드가
			// 자동으로 override가 되고 여기서 "?"를 채운다.
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, mvcboardVO.getName());
				ps.setString(2, mvcboardVO.getSubject());
				ps.setString(3, mvcboardVO.getContent());
			}
		});
		
		
		/* update() : 테이블의 내용이 갱신되는 sql 명령 =>insert, delete,update
		 * query() : 테이블의 내용이 갱신되지 않는 sql 명령 => select => 실행결과가 여러건일 경우 사용한다.
		 * queryForInt():테이블의 내용이 갱신되지 않는 sql 명령 => select => 실행결과 정수일 경우 사용한다.
		 * queryForObject():테이블의 내용이 갱신되지 않는 sql 명령 => select => 실행결과 1건 일때 사용한다.
		 * 
		 * 
		 * 
		 * 
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into mvcboard (idx, name, subject, content, gup, lev, seq) " + 
					"values (mvcboard_idx_seq.nextval, ?, ?, ?, mvcboard_idx_seq.currval, 0, 0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mvcboardVO.getName());
			pstmt.setString(2, mvcboardVO.getSubject());
			pstmt.setString(3, mvcboardVO.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		*/
		
		
	}
	
	// 게시글의 총 개수
	public int selectCount() {
		logger.info("selectCount()");
		
		
		/*
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = dataSource.getConnection();
			String sql = "select count(*) from mvcboard";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return result;
		*/
		
		String sql = "select count(*) from mvcboard";
//		queryForObject(sql명령, 리턴타입.class)
		return template.queryForObject(sql, Integer.class);
	}
	
	
	public MvcboardVO selectByIdx(int idx) {
		logger.info("selectByIdx()");
		/*
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MvcboardVO mvcboardVO = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select * from mvcboard where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
				mvcboardVO = ctx.getBean("mvcboardVO", MvcboardVO.class);
				mvcboardVO.setIdx(rs.getInt("idx"));
				mvcboardVO.setName(rs.getString("name"));
				mvcboardVO.setSubject(rs.getString("subject"));
				mvcboardVO.setContent(rs.getString("content"));
				mvcboardVO.setGup(rs.getInt("gup"));
				mvcboardVO.setLev(rs.getInt("lev"));
				mvcboardVO.setSeq(rs.getInt("seq"));
				mvcboardVO.setHit(rs.getInt("hit"));
				mvcboardVO.setWriteDate(rs.getTimestamp("writeDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
		}
		return mvcboardVO;
		*/
		
		String sql = "select * from mvcboard where idx= " + idx;	
		
		return template.queryForObject(sql,
					new BeanPropertyRowMapper(MvcboardVO.class));
	}
	
	public  void delete(final int idx) {
		logger.info("delete()");
		
		String sql = "delete from mvcboard where idx = " + idx;
		template.update(sql);
	}

}