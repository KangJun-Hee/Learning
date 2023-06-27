package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {

	private BookDAO() {
	}

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
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 관리자 인증 메서드
	public int managerCheck(String id, String pw) {
		int check = -1;

		try {
			conn = getConnection();

			String sql = "select * from manager where id=? and pw=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				check = 1;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				if (conn != null) {
					conn.close();
					pstmt.close();
					rs.close();
				}
			} catch (Exception e) {
			}
		}
		return check;
	}

	// 책 등록
		public void insertBook(BookDTO dto) {
			try {
				conn = getConnection();
				
				int number = 0;
				
				String sql = "SELECT MAX(book_id) FROM book";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					number = rs.getInt(1);
				}
				
				sql = "INSERT INTO book VALUES(?,?,?,?,?,?,?,?,?,?,?,now())";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, number + 1);
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
				e.printStackTrace();
			}finally {
				if(conn != null) {try {conn.close();} catch (SQLException e) {}}
				if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
			}
		}
		
		// 전체 등록된 책의 개수
		public int getBookCount() {
			int count = 0;
			try {
				conn = getConnection();
				
				String sql = "SELECT COUNT(*) FROM book";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt(1);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(conn != null) {try {conn.close();} catch (SQLException e) {}}
				if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
				if(rs != null) {try {rs.close();} catch (SQLException e) {}}
			}
			return count;
		}
		
		// 분류별 또는 전체 등록된 책의 정보
		public ArrayList<BookDTO> getBooks(String book_kind){
			
			ArrayList<BookDTO> bookList = null;
			
			try {
				conn = getConnection();
				
				String sql = "SELECT * FROM book";
				
				if(book_kind.equals("all")) {
					pstmt = conn.prepareStatement(sql);
				}else {
					sql = "SELECT * FROM book WHERE book_kind=? ORDER BY reg_date DESC";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, book_kind);
				}
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					bookList = new ArrayList<BookDTO>();
	                do{
	                     BookDTO dto= new BookDTO();
	                     
	                     dto.setBook_id(rs.getInt("book_id"));
	                     dto.setBook_kind(rs.getString("book_kind"));
	                     dto.setBook_title(rs.getString("book_title"));
	                     dto.setBook_price(rs.getInt("book_price"));
	                     dto.setBook_count(rs.getInt("book_count"));
	                     dto.setAuthor(rs.getString("author"));
	                     dto.setPublishing_com(rs.getString("publishing_com"));
	                     dto.setPublishing_date(rs.getString("publishing_date"));
	                     dto.setBook_image(rs.getString("book_image"));
	                     dto.setDiscount_rate(rs.getInt("discount_rate"));
	                     dto.setReg_date(rs.getString("reg_date"));
	                     
	                     bookList.add(dto);
				    }while(rs.next());				
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(conn != null) {try {conn.close();} catch (SQLException e) {}}
				if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
				if(rs != null) {try {rs.close();} catch (SQLException e) {}}
			}
			return bookList;
		}
		
		// 쇼핑몰 메인에 표시하기 위해서 사용하는 분류별 신간 책 목록
		public BookDTO[] getBooks(String book_kind, int count) {
			
			BookDTO[] bookList = null;
			int i = 0;
			
			try {
				conn = getConnection();
				
				String sql = "SELECT * FROM book WHERE book_kind=? ";
				sql += "ORDER BY reg_date DESC LIMIT ?,?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, book_kind);
				pstmt.setInt(2, 0);
				pstmt.setInt(3, count);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					bookList = new BookDTO[count];
					do {
						BookDTO dto = new BookDTO();
						dto.setBook_id(rs.getInt("book_id"));
						dto.setBook_kind(rs.getString("book_kind"));
						dto.setBook_title(rs.getString("book_title"));
						dto.setBook_price(rs.getInt("book_price"));
						dto.setBook_count(rs.getInt("book_count"));
						dto.setAuthor(rs.getString("author"));
						dto.setPublishing_com(rs.getString("publishing_com"));
						dto.setPublishing_date(rs.getString("publishing_date"));
						dto.setBook_image(rs.getString("book_image"));
						dto.setDiscount_rate(rs.getInt("discount_rate"));
						dto.setReg_date(rs.getString("reg_date"));
						
						bookList[i] = dto;
						
						i++;
					}while(rs.next());
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(conn != null) {try {conn.close();} catch (SQLException e) {}}
				if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
				if(rs != null) {try {rs.close();} catch (SQLException e) {}}
			}
			return bookList;
		}
		
		// book_id를 전달받아 한개의 책 정보
		public BookDTO getBook(int book_id) {
			BookDTO dto = null;
			try {
				conn = getConnection();
				
				String sql = "SELECT * FROM book WHERE book_id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, book_id);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					dto = new BookDTO();
					
					dto.setBook_kind(rs.getString("book_kind"));
					dto.setBook_title(rs.getString("book_title"));
					dto.setBook_price(rs.getInt("book_price"));
					dto.setBook_count(rs.getInt("book_count"));
					dto.setAuthor(rs.getString("author"));
					dto.setPublishing_com(rs.getString("publishing_com"));
					dto.setPublishing_date(rs.getString("publishing_date"));
					dto.setBook_image(rs.getString("book_image"));
					dto.setBook_content(rs.getString("book_content"));
					dto.setDiscount_rate(rs.getInt("discount_rate"));				
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(conn != null) {try {conn.close();} catch (SQLException e) {}}
				if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
				if(rs != null) {try {rs.close();} catch (SQLException e) {}}
			}
			return dto;
		}
		
		// 등록된 책의 정보 수정
		public void updateBoard(BookDTO dto, int book_id) {
			try {
				conn = getConnection();
				
				String sql = "UPDATE BOOK SET book_kind=?, book_title=?, book_price=?";
	            sql += ",book_count=?,author=?,publishing_com=?,publishing_date=?";
	            sql += ",book_image=?,book_content=?,discount_rate=?";
	            sql += " where book_id=?";
	            
	            pstmt = conn.prepareStatement(sql);
	            
	            pstmt.setString(1, dto.getBook_kind());
	            pstmt.setString(2, dto.getBook_title());
	            pstmt.setInt(3, dto.getBook_price());
	            pstmt.setInt(4, dto.getBook_count());
	            pstmt.setString(5, dto.getAuthor());
	            pstmt.setString(6, dto.getPublishing_com());
				pstmt.setString(7, dto.getPublishing_date());
				pstmt.setString(8, dto.getBook_image());
				pstmt.setString(9, dto.getBook_content());
				pstmt.setInt(10, dto.getDiscount_rate());
				pstmt.setInt(11, book_id);
				
				pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(conn != null) {try {conn.close();} catch (SQLException e) {}}
				if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
			}
		}
		
		// book_id를 전달받아 해당 책 정보 삭제
		public void deleteBook(int book_id) {
			try {
				conn = getConnection();
				
				String sql = "DELETE FROM book WHERE book_id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, book_id);
				
				pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(conn != null) {try {conn.close();} catch (SQLException e) {}}
				if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
			}
		}
		
		public int i(String id, String pw) {
			int check = -1;
			try {
				conn = getConnection();
				
				String sql = 
				"INSERT INTO book (book_id, book_kind, book_title, book_price, book_count, author, "
				+ "publishing_com, publishing_date, book_image, book_content, discount_rate, reg_date)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
				
				pstmt = conn.prepareStatement(sql);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				
			}
			return check;
		}

}
