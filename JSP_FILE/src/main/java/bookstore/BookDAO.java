package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDAO {
	
	private BookDAO() {}
	private static BookDAO instance = new BookDAO();
	public static BookDAO getInstance() {
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private Connection getConnection() {
		String dbURL = "jdbc:mysql://localhost:3306/onlineBook?serverTimezone=UTC&useSSL=false";
		String dbID = "root";
		String dbPassword = "1234";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}	
	
	
	//관리자 인증 메서드 
	public int managerCheck(String id, String pw) {
		int check = -1;
		
		try {
			conn = getConnection();
			
			String sql = "select * from manager where id=? and pw=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				check =1;
			}				
		}catch(Exception e) {
			System.out.println(e.toString());
		}finally {
			try {
				if(conn != null) {conn.close();
					pstmt.close();
					rs.close();				
				}				
			}catch(Exception e) {}
		}		
		return check;
	}
	
	// 책 등록
	public void insertBook(BookDTO dto) {
		
		try {
			conn = getConnection();
			int num = 0;
			
			String sql = "select max(book_id) from book";
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1);
			}
			
			sql = "insert into book values(?,?,?,?,?,?,?,?,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num + 1); 
			pstmt.setString(2, dto.getBook_kind());
			pstmt.setString(3, dto.getBook_title());
			pstmt.setInt(4, dto.getBook_price());
			pstmt.setInt(5, dto.getBook_count());
			pstmt.setString(6, dto.getAuthor());
			pstmt.setString(7, dto.getPublishing_com());
			pstmt.setString(8, dto.getPublishing_date());
			pstmt.setString(9, dto.getBook_image());
			pstmt.setString(10, dto.getBook_content());
			pstmt.setInt(11, dto.getDiscount_rate());
			pstmt.executeUpdate();	
			
						
		}catch(Exception e) {
			System.out.println(e.toString());
		}finally {
			try {
				if(conn != null) {conn.close();
					pstmt.close();
					rs.close();				
				}				
			}catch(Exception e) {}
		}				
	}
	
}
