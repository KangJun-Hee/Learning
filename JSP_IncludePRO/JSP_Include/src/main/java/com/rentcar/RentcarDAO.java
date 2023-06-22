package com.rentcar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentcarDAO {

	public static RentcarDAO instance = new RentcarDAO();
	public String realpath = "";
	String filename = "/rentcardata.txt";

	// 데이터를 저장해서 활용
	ArrayList<Rentcar> rentcarList = new ArrayList<>();
	ArrayList<Member> memberList = new ArrayList<>();
	ArrayList<CarReserve> carReserveList = new ArrayList<>();

	// mysql 에 연결하는 함수를 작성
	public Connection getConnection() {
		Connection conn = null;

		// 데이터베이스에 연결하는 내용을 작성!
		try {
			Class.forName("com.mysql.jc.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/rentcardb04?serverTimezone=UTC";

			conn = DriverManager.getConnection(url, "root", "1234");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스가 없거나 읽어 올 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("데이터베이스 접속 정보가 올바르지 않습니다.");
		}

		return conn;
	}

	// 회원이 있으면 1을 돌려준다. 없으면 0
	public int getMember(String id, String pw) {
		int result = 0;

		for (int i = 0; i < memberList.size(); i++) {
			if (id.equals(memberList.get(i).getId()) && pw.equals(memberList.get(i).getPw1())) {
				result = 1;
				break;
			}
		}

		return result;

	}
	
	public ArrayList<Rentcar> getSelectCar3(){
	
		ArrayList<Rentcar> list = new ArrayList<>();
		
		for(int i = 0; i<rentcarList.size(); i++) {
			
			list.add(rentcarList.get(i));
			if(i >= 2) {
				return list;
			}		
		}
		return list;		
	}	
	// getCategoryCar(category)
	public ArrayList<Rentcar> getCategoryCar(int cate){
		
		ArrayList<Rentcar> list = new ArrayList<>();
		
		// rentcarList안에서 반복을 하면서 카테고리 내용을 가지고 와서 cate비교해서 
		// 같은 값만 리스트에 넣어서 반환한다. 
		
		for (int i = 0; i < rentcarList.size(); i++) {
			if (rentcarList.get(i).getCategory() == cate) {

				list.add(rentcarList.get(i));
			}
		}
		/*
		for(Rentcar temp : rentcarList) {
			
			if(temp.getCategory() == cate) {
				list.add(temp);
			}			
		}
		*/
		
		return list;
		
	}
	
	// 리스트에서 no을 이용해서 데이터를 꺼내가기!
	public Rentcar getOneCar(int no) {
		
		// 실제 번호 1,2,3,4 -> 리스트에 저장되는 값은 좀 다르다!
		no = no -1;
		return rentcarList.get(no);		
	}	
	
	// 예약 리스트에 저장하기 !
	public void setReserveCar(CarReserve bean) {
		
		// 예약리스트에서 공통적인 예약번호를 적기위해서 가장큰 번호를 가지고 온다.
		int max_num = 0;
		
		if(carReserveList.size() > 0) {
			int last = carReserveList.size() -1;
			max_num = carReserveList.get(last).getNo();
		}
		// 만약 데이터가 처음 저장 되는 것이라면 그냥 추가 
		bean.setReserve_seq(max_num);
		carReserveList.add(bean);
		
		// 파일에 저장하는 메서드를 호출!
	}
	
	
	
	
	
	
	
	// 회원가입이 없어서 미리 초기 설정
	public void memberBasicSet() {

		Member mb = new Member();
		mb.setId("aa");
		mb.setPw1("11");

		memberList.add(mb);

		mb = new Member();
		mb.setId("bb");
		mb.setPw1("22");

		memberList.add(mb);
	}

	// 렌트카에 대한 기본 설정
	public void rentcarBasicSet() {

		rentcarList.clear();
		Rentcar rc;
		rc = new Rentcar(1, "아반테", 1, 2000, 4, "기아", "rent_1.jpg", "아반테 자동차 입니다.");
		rentcarList.add(rc);
		rc = new Rentcar(2, "BMW", 3, 6000, 4, "BMW", "rent_2.jpg", "BMW 자동차 입니다.");
		rentcarList.add(rc);
		rc = new Rentcar(3, "카니발", 1, 4000, 7, "기아", "rent_3.jpg", "카니발 자동차 입니다.");
		rentcarList.add(rc);
		rc = new Rentcar(4, "카렌스", 2, 2500, 4, "기아", "rent_4.jpg", "카렌스 자동차 입니다.");
		rentcarList.add(rc);
		rc = new Rentcar(5, "코란도", 1, 3000, 4, "현대", "rent_5.jpg", "코란도 자동차 입니다.");
		rentcarList.add(rc);
		rc = new Rentcar(6, "에쿠스", 3, 6000, 4, "BMW", "rent_6.jpg", "에쿠스 자동차 입니다.");
		rentcarList.add(rc);
		rc = new Rentcar(7, "제네시스", 1, 3000, 4, "기아", "rent_7.jpg", "제네시스 자동차 입니다.");
		rentcarList.add(rc);
		rc = new Rentcar(8, "그랜져", 1, 2400, 4, "현대", "rent_8.jpg", "그랜져 자동차 입니다.");
		rentcarList.add(rc);
		rc = new Rentcar(9, "k3", 1, 2700, 4, "현대", "rent_9.jpg", "k3 자동차 입니다.");
		rentcarList.add(rc);
		rc = new Rentcar(10, "k5", 2, 5000, 4, "기아", "rent_10.jpg", "k5 자동차 입니다.");
		rentcarList.add(rc);
		rc = new Rentcar(11, "k9", 1, 6000, 4, "현대", "rent_11.jpg", "k9 자동차 입니다.");
		rentcarList.add(rc);
		rc = new Rentcar(12, "라세티", 2, 2000, 5, "기아", "rent_12.jpg", "라세티 자동차 입니다.");
		rentcarList.add(rc);
		rc = new Rentcar(13, "lf소나타", 1, 2000, 4, "현대", "rent_13.jpg", "lf소나타 자동차 입니다.");
		rentcarList.add(rc);
		rc = new Rentcar(14, "말리부", 3, 2000, 4, "BMW", "rent_14.jpg", "말리부 자동차 입니다.");
		rentcarList.add(rc);
		rc = new Rentcar(15, "모닝", 1, 23000, 4, "현대", "rent_15.jpg", "모닝 자동차 입니다.");
		rentcarList.add(rc);
		rc = new Rentcar(16, "올라도", 3, 5000, 4, "BMW", "rent_16.jpg", "올라도 자동차 입니다.");
		rentcarList.add(rc);
		rc = new Rentcar(17, "레이", 2, 4000, 4, "현대", "rent_17.jpg", "레이 자동차 입니다.");
		rentcarList.add(rc);
		rc = new Rentcar(18, "SM5", 1, 2700, 4, "BMW", "rent_18.jpg", "SM5 자동차 입니다.");
		rentcarList.add(rc);

	}

}
