import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class dbtest4 {

	public static void main(String[] args) {
		//데이터베이스를 이용해서 테이블 내용을 꺼내온다.
		//bookVO클래스를 이용해서 객체 생성해서 arraylist에 넣어서 전체출력하세요!
		//	출력할 때는 메서드 이용해도 되고 내가만든 메서드에 arraylist 전달해도 됩니다.
		ArrayList<BeveragesVO> list = new ArrayList<>();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/coffee_store?serverTimezone=UTC";
			String user = "root";
			String pass = "1234";

			Connection con = DriverManager.getConnection(url, user, pass);

			if (con != null) {
				System.out.println("DB연결 성공!");
			}

			// DB와 연결된 conn객체로 부터 Statement 객체 획득.
			// 내가 데이터베이스에게 질의를 할 수 있다 .
			Statement stmt = con.createStatement();

			// 조회 select * from
			// 쿼리문이 데이터를 가지고 온다. 객체 형식
			// next() 다음 데이터가 있으면 true, 없으면 false
			ResultSet result = stmt.executeQuery("select * from beverages");

			while (result.next()) {

				// 인덱스를 이용해서 0 부터
				// 컬럼이름을 이용해서 데이터를 뽑는게 더 안전하다.
				// getString("컬럼이름")
				int id = Integer.parseInt(result.getString("id"));
				String name = result.getString("name");
				int price = Integer.parseInt(result.getString("price"));
				String btype = result.getString("btype");

				System.out.println("번호    :" + id);
				System.out.println("메뉴명  :" + name);
				System.out.println("메뉴가격 :" + price);
				System.out.println("메뉴타입 :" + btype);
				System.out.println();
				
				list.add(new BeveragesVO(id,name,price,btype));
				
				

			}
			
			System.out.println(list);
			
			

			// query만들기
			// 문자열로 넘어갑니다.
//			StringBuilder sb = new StringBuilder();
//			String sql = sb.append("create table if not exists students(")
//						.append("id int,")
//						.append("grade int")
//						.append(");")
//						.toString();
//			
//			System.out.println(sql);

			// query문 날리기!
			// stmt.execute(sql);

			//

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스가 없거나 읽어올 수 없습니다.");
			e.printStackTrace();

		} catch (SQLException e) {
			System.out.println("데이터베이스 접속 정보가 올바르지 않습니다.");
			e.printStackTrace();
		}

	}
}