import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementTest {

	public static void main(String[] args) {
		Connection conn = null; // DB연결된 상태(세션)을 담은 객체
        PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
        
        try {
            									//  1, 2, 3
            String quary = "INSERT INTO TEST VALUES(?, ?, ?)";
            
            conn = DBcon.getConnection();
            pstm = conn.prepareStatement(quary);
            
            // 쿼리에 값을 세팅한다.
            // 여기서 1, 2, 3은 첫번째, 두번째, 세번째 위치홀더 라는 뜻
            pstm.setString(1, "id2");//고정해뒀지만 변수값으로 넣으면 값도 바뀔 때마다 새로
            pstm.setString(2, "pw2");
            pstm.setString(3, "name2");
            
            int success = pstm.executeUpdate();//보낸다,저장해라~
            
            if(success > 0)
                System.out.println("데이터 입력 성공");
            else
                System.out.println("데이터 입력 실패");
        }catch(SQLException sqle) {
        	sqle.printStackTrace();
        }
	}

}