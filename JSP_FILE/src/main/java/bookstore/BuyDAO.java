package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BuyDAO {

	private BuyDAO() {}
	private static BuyDAO instance = new BuyDAO();
	public static BuyDAO getInstance() { return instance; }
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// DB연동
	private Connection getConnection() throws Exception {
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
	
	// buy 테이블의 전체 레코드 수
	public int getListCount() {
		
		int count = 0;
		
		try {
			conn = getConnection();
			
			String sql = "SELECT COUNT(*) FROM buy";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {try {rs.close();} catch (SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
			if(conn != null) {try {conn.close();} catch (SQLException e) {}}
		}
		return count;
	}
	
	// bank 테이블 정보 꺼내오기
	public List<String> getAccount(){

		List<String> accountList = null;
		
		try {
			
			conn = getConnection();
			
			String sql = "SELECT * FROM bank";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			accountList = new ArrayList<String>();
			
			// 신한은행에 대해서 꺼내와서 하나의 문장으로 저장 후 
			// arraylist에 저장하는 내용!
			while(rs.next()) {
				String account = rs.getString("account") + " " 
								  + rs.getString("bank") + " " 
								  + rs.getString("name");
				accountList.add(account);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {try {rs.close();} catch (SQLException e) {}}
			if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
			if(conn != null) {try {conn.close();} catch (SQLException e) {}}
		}
		return accountList;
	}
	
    //구매 테이블인 buy에 구매목록 등록
    public void insertBuy( List<CartDTO> lists, String id, String account, String deliveryName, String deliveryTel, String deliveryAddress){
       
        int buyId = 0; 
        int nowCount = 0;		
        
        try {

        	conn = getConnection();
            
            String sql = "SELECT MAX(buy_id) FROM buy";
            pstmt = conn.prepareStatement(sql);
            
            rs = pstmt.executeQuery();
            if(rs.next()) {
            	buyId = rs.getInt(1);
            }
            
            for(int i=0; i<lists.size();i++){
            	//해당 아이디에 대한 cart테이블 레코드를을 가져온후 buy테이블에 추가
            	CartDTO cart = lists.get(i);
            	
            	sql = "INSERT INTO buy (buy_id,buyer,book_id,book_title,buy_price,buy_count,";
                sql += "book_image,buy_date,account,deliveryName,deliveryTel,deliveryAddress,sanction)";
                sql += " values (?,?,?,?,?,?,?,now(),?,?,?,?,?)";
                pstmt = conn.prepareStatement(sql);
            
                pstmt.setLong(1, buyId + 1);
                pstmt.setString(2, id);
                pstmt.setInt(3, cart.getBook_id());
                pstmt.setString(4, cart.getBook_title());
                pstmt.setInt(5, cart.getBuy_price());
                pstmt.setInt(6, cart.getBuy_count());
                pstmt.setString(7, cart.getBook_image());
                pstmt.setString(8, account);
                pstmt.setString(9, deliveryName);
                pstmt.setString(10, deliveryTel);
                pstmt.setString(11, deliveryAddress);
                pstmt.setString(12, "배송준비중");
                pstmt.executeUpdate();
                
                //상품이 구매되었으므로 book테이블의 상품수량을 재조정함
                sql = "SELECT book_count FROM book WHERE book_id=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, cart.getBook_id());
                rs = pstmt.executeQuery();
                
                if(rs.next()) {
                	nowCount = rs.getInt(1) - cart.getBuy_count();
                }
                
                sql = "UPDATE book SET book_count=? WHERE book_id=?";
                pstmt = conn.prepareStatement(sql);
           
                pstmt.setInt(1, nowCount);
    			pstmt.setInt(2, cart.getBook_id());
                
                pstmt.executeUpdate(); 
            }
            
            // 장바구니 비우기
            sql = "DELETE FROM cart WHERE buyer=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
          
            pstmt.executeUpdate();
            
        }catch(Exception e) {
        	e.printStackTrace();
        } finally {
            if (pstmt != null) {try { pstmt.close(); } catch(SQLException ex) {}}
            if (conn != null) {try { conn.close(); } catch(SQLException ex) {}}
        }
    }
    
    //id에 해당하는 buy테이블의 레코드수를 얻어내는 메소드
    public int getListCount(String id) {

        int count = 0;

        try {
            conn = getConnection();
            
            String sql = "SELECT COUNT(*) FROM buy WHERE buyer=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
               count = rs.getInt(1);
			}
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(rs != null) {try {rs.close();} catch (SQLException e) {}}
            if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
            if(conn != null) {try {conn.close();} catch (SQLException e) {}}
        }
		return count;
    }
    

    //id에 해당하는 buy테이블의 구매목록을 얻어내는 메소드
    public List<BuyDTO> getBuyList(String id) {

    	BuyDTO buy = null;
        List<BuyDTO> lists = null;
        
        try {
       	    conn = getConnection();
       	 
       	    String sql = "SELECT * FROM buy WHERE buyer=?";
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            
            lists = new ArrayList<BuyDTO>();

            while (rs.next()) {
              buy = new BuyDTO();
           	 
           	  buy.setBuy_id(rs.getInt("buy_id"));
           	  buy.setBook_id(rs.getInt("book_id"));
           	  buy.setBook_title(rs.getString("book_title"));
           	  buy.setBuy_price(rs.getInt("buy_price"));
           	  buy.setBuy_count(rs.getByte("buy_count")); 
           	  buy.setBook_image(rs.getString("book_image"));
           	  buy.setSanction(rs.getString("sanction"));
           	 
           	  lists.add(buy);
			}
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(rs != null) {try {rs.close();} catch (SQLException e) {}}
            if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
            if(conn != null) {try {conn.close();} catch (SQLException e) {}}
        }
		return lists;
    }
    
    //buy테이블의 전체 목록을 얻어내는 메소드
    public List<BuyDTO> getBuyList()  {
        BuyDTO buy=null;
        List<BuyDTO> lists = null;	
        
        try {
       	 	conn = getConnection();
       	 
       	 	String sql = "SELECT * FROM buy";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            lists = new ArrayList<BuyDTO>();

            while (rs.next()) {
              buy = new BuyDTO();
           	 
           	  buy.setBuy_id(rs.getInt("buy_id"));
           	  buy.setBuyer(rs.getString("buyer"));
           	  buy.setBook_id(rs.getInt("book_id"));
           	  buy.setBook_title(rs.getString("book_title"));
           	  buy.setBuy_price(rs.getInt("buy_price"));
           	  buy.setBuy_count(rs.getByte("buy_count")); 
           	  buy.setBook_image(rs.getString("book_image"));
           	  buy.setBuy_date(rs.getString("buy_date"));
           	  buy.setAccount(rs.getString("account"));
           	  buy.setDeliveryName(rs.getString("deliveryName"));
           	  buy.setDeliveryTel(rs.getString("deliveryTel"));
           	  buy.setDeliveryAddress(rs.getString("deliveryAddress"));
           	  buy.setSanction(rs.getString("sanction"));
           	 
           	  lists.add(buy);
		    }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(rs != null) {try {rs.close();} catch (SQLException e) {}}
            if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {}}
            if(conn != null) {try {conn.close();} catch (SQLException e) {}}
        }
		return lists;
    }
}



/*
 * public Map<String, String> getBank() {
		
		Map<String, String> bankList = null;
		try {
			bankList = new HashMap<>();
			
			conn = getConnection();
			String sql = "select * from bank";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String bank = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3);
				
				bankList.put(rs.getString(2), bank);
			}
			for(String key : bankList.keySet()) {
				String value = (String) bankList.get(key);
				System.out.println(key + " : " + value);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		return bankList;
	}
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */































