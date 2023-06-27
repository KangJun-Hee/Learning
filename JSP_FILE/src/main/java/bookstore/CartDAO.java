package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {

	private CartDAO() {
	}

	private static CartDAO instance = new CartDAO();

	public static CartDAO getInstance() {
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

	// id에 해당하는 장바구니 목록
	public List<CartDTO> getCart(String id) {

		CartDTO cart = null;
		List<CartDTO> lists = null;

		try {

			conn = getConnection();

			String sql = "SELECT * FROM cart WHERE buyer=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			lists = new ArrayList<CartDTO>();

			while (rs.next()) {
				cart = new CartDTO();

				cart.setCart_id(rs.getInt("cart_id"));
				cart.setBook_id(rs.getInt("book_id"));
				cart.setBook_title(rs.getString("book_title"));
				cart.setBuy_price(rs.getInt("buy_price"));
				cart.setBuy_count(rs.getInt("buy_count"));
				cart.setBook_image(rs.getString("book_image"));

				lists.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return lists;
	}

	// id에 해당하는 레코드의 수를 얻어내는 메서드
	public int getListCount(String id) {

		int count = 0;

		try {
			conn = getConnection();

			String sql = "SELECT COUNT(*) FROM cart WHERE buyer=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return count;
	}

	// 장바구니 담기를 누르면 수행되는 것으로 cart테이블에 새로운 레코드를 추가
public void insertCart(CartDTO cart) {
		
		int cart_id = 0;
		
		try {
			conn = getConnection();
			
			String sql = "SELECT MAX(cart_id) FROM cart";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cart_id = rs.getInt(1);
			}
			
			sql = "INSERT INTO cart (cart_id, book_id, buyer, book_title, buy_price, buy_count, book_image) ";
			sql += "VALUES (?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cart_id+1);
            pstmt.setInt(2, cart.getBook_id());
            pstmt.setString(3, cart.getBuyer());
            pstmt.setString(4, cart.getBook_title());
            pstmt.setInt(5, cart.getBuy_price());
            pstmt.setInt(6, cart.getBuy_count());
            pstmt.setString(7, cart.getBook_image());
            
            pstmt.executeUpdate();			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
			if(conn != null) {try {conn.close();} catch (SQLException e) {}}
		}
	}

}
