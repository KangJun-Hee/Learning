package com.rentcar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentcarDAO {
	public static RentcarDAO instance = new RentcarDAO();
	public String realpath = "";
	String filename = "/rentcardata.txt";

	// 데이터를 저장해 활용
	ArrayList<Rentcar> rentcarList = new ArrayList<>();
	ArrayList<Member> memberList = new ArrayList<>();
	ArrayList<CarReserve> carReserveList = new ArrayList<>();

	public Connection getConnection() {
		Connection conn = null;

		// 데이터베이스 연결내용 작성!!
		try {
			String user = "system";
			String pw = "1234";
			String url = "jdbc:oracle:thin@localhost:1521:orcl";

			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, user, pw);

			System.out.println("연결~");
		} catch (ClassNotFoundException e) {
			System.out.println("데이터베이스 연결 에러~" + e.toString());
		} catch (SQLException e) {
			System.out.println("DB접속 안됐다~ : " + e.toString());
		}
		return conn;
	}

	// 회원있으면 1리턴,없으면 0
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

	public ArrayList<Rentcar> getSelectCar3() {
		ArrayList<Rentcar> list = new ArrayList<>();

		for (int i = 0; i < rentcarList.size(); i++) {
			list.add(rentcarList.get(i));
			if (i >= 2) {
				return list;
			}
		}
		return list;
	}

	public ArrayList<Rentcar> getCategoryCar(int cate){
		ArrayList<Rentcar> list = new ArrayList<>();
		
		//rentcarList안에서 반복하며 카테고리내용 가지고 와서 cate비교해
		//같은 값만 리스트에 넣어서 반환
		for (int i = 0; i < rentcarList.size(); i++) {
			if (rentcarList.get(i).getCategory() == cate) {
				list.add(rentcarList.get(i));
			}
		}
		return list;
	}
	
	//리스트에서 no를 이용해서 데이터를 꺼내가기~
	public Rentcar getOneCar(int no) {
		//실제번호1,2,3와 리스트에 저장되는 값은 좀 다르다~ 0부터 시작하니까
		no-=1;
		return rentcarList.get(no);
	}
	
	//예약리스트에 저장하기~
	public void setReserveCar(CarReserve bean) {
		//예약리스트에서 공통적인 예약번호 적기위해 가장큰번호 갖고온다~
		int max_num = 0;
		
		if(carReserveList.size() > 0) {
			int last = carReserveList.size()-1;
			max_num = carReserveList.get(last).getNo();
		}
		//만약 데이터가 첨 저장되는 거라면 걍 추가
		bean.setReserve_seq(max_num);
		carReserveList.add(bean);
		
		//파일에 저장하는 메서드를 호출!
	}
	
	
	// 회원가입 없으니 미리 초기설정
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

	// 렌트카에 대한 기본설정
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
