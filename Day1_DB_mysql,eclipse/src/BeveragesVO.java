public class BeveragesVO {
	
	private int id;
	private String name;
	private int price;
	private String btype;
	
	
	
	
	
	public BeveragesVO() {
		super();
	}

	public BeveragesVO(int id, String name, int price, String btype) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.btype = btype;
	}
	
	@Override
	public String toString() {
		return "BeveragesVO [id=" + id + ", name=" + name + ", price=" + price + ", btype=" + btype + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getBtype() {
		return btype;
	}

	public void setBtype(String btype) {
		this.btype = btype;
	}

}