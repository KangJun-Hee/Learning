import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class dbtest2 {

	public static void main(String[] args) {
		
		
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("================================");
			System.out.println("1.입력 2.목록보기 3.수정 4.삭제 5.종료");
			System.out.println("================================");
			System.out.println("원하는 메뉴를 선택하세요:");
			int num = sc.nextInt();
			
			
			switch (num) {
			case 1:
				System.out.println("이름:");
				sc.next();
				System.out.println("비밀번호:");
				sc.nextInt();
				System.out.println("메모:");
				sc.next();
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				System.out.println("프로그램을 종료합니다~");
				return;
				
			default:
				System.out.println("1~5 내의 숫자를 선택해 주세요!!!");
				break;
			}
		}
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/bookstore?serverTimezone=UTC";
//			String user = "root";
//			String pass = "1234";
//
//			Connection conn = DriverManager.getConnection(url, user, pass);
//
//			if (conn != null) {
//				System.out.println("DB 연결 완료");
//			}
//
//			// DB와 연결된 conn객체로 부터 Statement 객체 획득.
//			// 내가 데이터베이스에게 질의를 할 수 있다 .
//			Statement stmt = conn.createStatement();
//
//			// 조회 select * from
//			// 쿼리문이 데이터를 가지고 온다. 객체 형식
//			// next() 다음 데이터가 있으면 true, 없으면 false
//			ResultSet result = stmt.executeQuery("select bookname,price from book");
//
//			while (result.next()) {// 출력값
//				int price = Integer.parseInt(result.getString("price"));
//				String bookname = result.getString("bookname");
//
//				System.out.println("price" + "         " + "bookname");
//				System.out.println(price + "      " + bookname);
//				System.out.println();
//			}
//		} catch (ClassNotFoundException e) {
//			System.out.println("JDBC"
//					+ " 드라이버 로드 에러!");
//		} catch (SQLException e) {
//			System.out.println("DB 연결 오류~");
//		}

	}
}
