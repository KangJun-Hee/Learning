import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbtest3 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/stu?serverTimezone=UTC";
			String user = "root";
			String pass = "1234";

			Connection con = DriverManager.getConnection(url, user, pass);

			if (con != null) {
				System.out.println("DB연결 성공쿵쿵따!");
			}
			
			//DB와 연결된 conn객체로부터 statement 객체 획득.
			//내가 데이터베이스에게 질의를 할 수 있다.
			Statement stmt = con.createStatement();
			
			//조회 select * from
			//쿼리문이 데이터를 가지고 온다. 객체 형식으로
			//next()다음 데이터가 있으면 true,없으면 false
			ResultSet result = stmt.executeQuery("select * from students");
			
			while(result.next()) {
				//인덱스를 이용해서 0부터 번호로 꺼내기도 함
				
				//컬럼명을 이용해서 데이터를 뽑는 게 더 안전하다.
				
				//getString("컬럼이름")
				int id=Integer.parseInt(result.getString("id"));
				
				System.out.println("학생id:"+id);
				
				
				
			}
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스가 읎거나 읽어올 수 읎습니다.");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("데이터베이스 접속 정보가 올바르지 않습니덩.");
			e.printStackTrace();
		}
		

	
	}
}
