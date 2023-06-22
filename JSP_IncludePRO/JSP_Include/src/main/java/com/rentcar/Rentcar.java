package com.rentcar;

public class Rentcar {
	// 렌트카 정보를 저장해서 조회를 했을 때 정보를 출력 
	private int no;				//차량저장 번호
	private String name; 		// 차량이름
	private int category;		// 차량 분류 소형, 대형, 중형
	private int price;			// 차량 가격
	private int user_people;	// 차량 탑승 인원
	private String company;		// 차량 회사
	private String img;			// 차량 이미지 파일명
	private String info;		// 차량에 대한 정보를 저자
	
	// 생성자 
	
	public Rentcar() {}
	public Rentcar(int no, String name, int category, int price, int user_people, String company, String img,
			String info) {
		
		this.no = no;
		this.name = name;
		this.category = category;
		this.price = price;
		this.user_people = user_people;
		this.company = company;
		this.img = img;
		this.info = info;
	}
	
	
	// setter getter 
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getUser_people() {
		return user_people;
	}
	public void setUser_people(int user_people) {
		this.user_people = user_people;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	//toString
	
	@Override
	public String toString() {
		return "[no=" + no + ", name=" + name + ", category=" + category 
				+ ", price=" + price + ", user_people="
				+ user_people + ", company=" + company 
				+ ", img=" + img + ", info=" + info + "]";
	}	
}
