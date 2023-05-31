import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbtest2 {

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
			
			
			//Query만들기
			//문자열로 넘어갑니다.
			StringBuilder sb = new StringBuilder();
			String sql = sb.append("create table if not exists student(")
					.append("id int,").append("grade int")
					.append(");")
					.toString();
			
			
			System.out.println(sql);
			
			//query문 날리기!
			stmt.execute(sql);
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스가 읎거나 읽어올 수 읎습니다.");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("데이터베이스 접속 정보가 올바르지 않습니덩.");
			e.printStackTrace();
		}
		

	
	}
}
