package Cafe;

public class Beve_OrderVO {

	private String name;
	private String price;
	private String btype;
	
	public Beve_OrderVO() {}
	public Beve_OrderVO(String name, String price, String btype) {
		super();
		this.name = name;
		this.price = price;
		this.btype = btype;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}

	@Override
	public String toString() {
		return "Beve_OrderVO [name=" + name + ", price=" + price + ", btype=" + btype + "]";
	};
	
	
	//Cafe 패키지
	// main 메뉴 보여 주고
	//		1.음료목록추가
	//		2.주문->커피이름,가격,개수,주문번호,총가격
	//		3.주문취소->주문번호 취소
	//		4.종료->오늘의 총 매출은 **입니다!
	
	/*
	 * VO객체
	 * DTO
	 * */
}
