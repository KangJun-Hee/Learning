import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class StatementTest {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stm = null;
		
		try {
			con = DBcon.getConnection();//객체 넘어 오게
			stm = con.createStatement();//질의할 수 잇게
			
													//문자니까 ''로.
			String quary = "insert into TEST values('id1','pw1','name1')";
			int success = stm.executeUpdate(quary);
			
			if(success > 0) {
				System.out.println("데이터 입력 성공!");
			}else {
				System.out.println("데이터 입력 실패~");
			}
			
		} catch (SQLException sql) {
			sql.printStackTrace();
			System.out.println(sql.toString());//에러날 수 잇으니 문자로 출력해주쇼
		}
		
		
		
		
	}
}

//		
//		Connection con= null; //DB연결된 상태(세션)을 담는 객체
//		PreparedStatement pstm = null; // sql문을 나타내는 객체
//		ResultSet rs = null;  // 쿼리문을 날린 것에 대한 반환값을 담는 객체 
//		
//		HashMap<String, CafeVO> list = new HashMap<>();
//		ArrayList<CafeVO> list2 = new ArrayList<>();
//		
//		
//		// 쿼리문을 전송할 수 있는 인터페이스 2가지 
//		// 공통점
//		//  둘다 쿼리를 전송기능을 가지고 있다. 
//		//  try ~ catch문으로 throw를 처리해야된다. 예외처리!
//		//  String객체를 전달한다. 
//		// Statement 정적인 쿼리문을 처리할 수 있다.
//		//  쿼리문에 값이 미리 입력 되어있어야한다. 
//		
//		//  Statement 컴파일이 될 때마다 서버에가서 컴파일을 계속해서 
//		//   정보를 가지고 온다. 
//		
//	
//		
//		
//		try {
//			//sql 문장을 만들고 만약 문장이 질의어(select문)라면 
//			// 그 결과를 담는 resultset객체를 준비한 후 실행한다. 
//			
//			String quary = "select * from cafe";
//			
//			con = DBcon.getConnection();
//			pstm = con.prepareStatement(quary);
//			rs = pstm.executeQuery();
//			
//			
//			while(rs.next()) {
//				String cafeid = rs.getString("cafeid");
//				String cafename = rs.getString("cafename");
//				String price = rs.getString("price");
//				String corporation = rs.getString("corporation");
//				
//				list.put(cafeid, new CafeVO(cafeid,cafename,
//						corporation,price));
//				
//				list2.add(new CafeVO(cafeid,cafename,
//						corporation,price));
//			}	
//			
//			// Map은 인덱스 X 
//			//  keyset()
//			for(String s : list.keySet()) {
//				System.out.println(list.get(s));
//			}
//			
//			// Arraylist 
//			for(CafeVO s : list2) {
//				System.out.println(s);
//			}
//			
//			System.out.println(list);
//			System.out.println(list2);
//		}catch(SQLException e) {
//			System.out.println("select  문에서 예외가 발생할 수 있다.");
//		}finally {
//			try {
//				if(rs != null) {rs.close();}
//				if(pstm != null) {pstm.close();}
//				if(con != null) {con.close();}
//				
//				
//			}catch(Exception e) {
//				System.out.println(e.toString());
//			}
//		}