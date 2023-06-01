import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CVS {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/pos?serverTimezone=UTC";
			String user = "root";
			String pass = "1234";

			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement pst = null;

			if (conn != null) {
				System.out.println("DB 연결 완료했다!!!!!!");
			}
			// DB와 연결된 conn(커넥션)객체로부터 Statement객체 획득.
			// 내가 DB에 질의를 할 수 있음!
			Statement stmt = conn.createStatement();

			// 조회하려면 select*from (mysql이랑 똑같)
			// 쿼리문이 데이터 갖고 옴. 객체형식
//			ResultSet result = stmt.executeQuery("select * from student");

			StringBuilder sb = new StringBuilder();
			String sql = sb.append("create table if not exists CVS(").append("id int,").append("pname varchar(20),")
					.append("count int,").append("price int").append(");").toString();
			System.out.println(sql);
			stmt.execute(sql);

			ResultSet result2 = stmt.executeQuery("select * from CVS");

			System.out.println("============================");
			System.out.println("  1.POS           2.재고관리");
			System.out.println("============================");
			while (true) {

				Scanner sc = new Scanner(System.in);
				int num = sc.nextInt();
				switch (num) {
				case 1:

					break;
				case 2:
					System.out.println("============================");
					System.out.println("          재고현황");
					System.out.println("============================");
					System.out.println("1.상품새로고침 2.등록 3.수정 4.삭제");
					System.out.println("============================");
					System.out.println("id   상품명    수량      가격");
					
					// next():다음 데이터가 있으면 true,없으면 false
					while (result2.next()) {// 아래가 출력값들
						int id = Integer.parseInt(result2.getString("id"));
						String pname = result2.getString("pname");
						int count = Integer.parseInt(result2.getString("count"));
						int price = Integer.parseInt(result2.getString("price"));

						System.out.println(id + "   " + pname + "      " + count + "      " + price);


						while (true) {
							int num2 = sc.nextInt();
							switch (num2) {
							case 1:
								
								break;
							case 2:
								System.out.println("상품id:");
								int id2 = sc.nextInt();
								System.out.println("상품명:");
								String pname2 = sc.next();
								System.out.println("수량:");
								int count2 = sc.nextInt();
								System.out.println("가격:");
								int price2 = sc.nextInt();
								
//								try {
//									sql = "INSERT INTO CVS VALUES (CVSSeq.nextval,?,?,?,?)";
//									pst = conn.prepareStatement(sql);
//									
//									//PreparedStatement방식
//									sql = "insert into score (hak,name,kor,eng,mat) ";
//									sql+= "values (?,?,?,?,?)"; //입력할 데이터가 5개면 ?를 5개 찍어주면 된다.
//									
//									pst.setInt(1, id2);
//									pst.setString(2, pname2);
//									pst.setInt(3, count2);
//									pst.setInt(4, price2);
//									
//									// executeUpdate:insert,delete,update(테이블에 변화 생길 때 사용되는 명령)
//									int cnt = pst.executeUpdate();
//									if (cnt > 0) {
//										System.out.println("상품등록 성공");
//									} else {
//										System.out.println("상품등록 실패");
//									}
//								} catch (Exception e) {
//									e.printStackTrace();
//								} finally {
//									try {
//										pst.close();
//										conn.close();
//									} catch (SQLException e2) {
//										e2.printStackTrace();
//									}
//								}
								//상품추가
//							    public boolean insertStock(Item item) {
//							        Connection conn = null;
//							        PreparedStatement pstmt = null;
//							        String sql = "INSERT INTO item (`item_name`, `item_stock`, `item_price`) VALUES (?, ?, ?)";
//							        boolean result = false;
//							        try {
//							            conn = DBconnect.connect();
//							            pstmt = conn.prepareStatement(sql);
//							            pstmt.setString(1, item.getItem_name());
//							            pstmt.setInt(2, item.getItem_stock());
//							            pstmt.setInt(3, item.getItem_price());
//							            int r = pstmt.executeUpdate();
//							            System.out.println("return result = " + r);
//							            if (r > 0) {
//							                result = true;
//							            }
//							        } catch (Exception e) {
//							            e.printStackTrace();
//							        } finally {
//							            DBconnect.close();
//							        }
//
//							        return result;
//							    }
								
								break;
							case 3:
								
								break;
							case 4:
								
								break;
								
							default:
								System.out.println("1~4번 중 선택해 주세요.");
								break;
							}
						}//
					}//재고현황 보는 while
					System.out.println("============================");
					break;

				default:
					System.out.println("1번과 2번 중 선택해 주세요.");
					return;
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스가 없거나 읽어 올 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("데이터베이스 접속 정보가 올바르지 않습니다.");
			e.printStackTrace();
		}
	}
}
