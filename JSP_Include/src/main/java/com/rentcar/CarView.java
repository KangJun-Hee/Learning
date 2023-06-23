package com.rentcar;

public class CarView {
	private String name;
	private int price;
	private String img;
	private int qty;
	private int dday;
	private String rday;
	private int usein;
	private int usewifi;
	private int useseat;
	private int usenavi;
	
	public CarView() {}
	public CarView(String name, int price, String img, int qty, int dday, String rday, int usein, int usewifi,
			int useseat, int usenavi) {
		super();
		this.name = name;
		this.price = price;
		this.img = img;
		this.qty = qty;
		this.dday = dday;
		this.rday = rday;
		this.usein = usein;
		this.usewifi = usewifi;
		this.useseat = useseat;
		this.usenavi = usenavi;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getDday() {
		return dday;
	}
	public void setDday(int dday) {
		this.dday = dday;
	}
	public String getRday() {
		return rday;
	}
	public void setRday(String rday) {
		this.rday = rday;
	}
	public int getUsein() {
		return usein;
	}
	public void setUsein(int usein) {
		this.usein = usein;
	}
	public int getUsewifi() {
		return usewifi;
	}
	public void setUsewifi(int usewifi) {
		this.usewifi = usewifi;
	}
	public int getUseseat() {
		return useseat;
	}
	public void setUseseat(int useseat) {
		this.useseat = useseat;
	}
	public int getUsenavi() {
		return usenavi;
	}
	public void setUsenavi(int usenavi) {
		this.usenavi = usenavi;
	}
	@Override
	public String toString() {
		return "CarView [name=" + name + ", price=" + price + ", img=" + img + ", qty=" + qty + ", dday=" + dday
				+ ", rday=" + rday + ", usein=" + usein + ", usewifi=" + usewifi + ", useseat=" + useseat + ", usenavi="
				+ usenavi + "]";
	}
	
	
}
