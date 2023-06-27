package bookstore;

public class CartDTO {
	private int cart_id;			// 장바구니 순서 1, 2, 3
	private String buyer;			// 구매자 로그인 id	
	private int book_id;			// 책 번호 
	private String book_title;		// 책 제목
	private int buy_price;			// 책 가격
	private int buy_count;			// 책 개수(수량)
	private String book_image;		// 책 이미지
	
	public CartDTO() {}

	public CartDTO(int cart_id, String buyer, int book_id, String book_title, int buy_price, int buy_count,
			String book_image) {
		
		this.cart_id = cart_id;
		this.buyer = buyer;
		this.book_id = book_id;
		this.book_title = book_title;
		this.buy_price = buy_price;
		this.buy_count = buy_count;
		this.book_image = book_image;
	}



	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public int getBuy_price() {
		return buy_price;
	}

	public void setBuy_price(int buy_price) {
		this.buy_price = buy_price;
	}

	public int getBuy_count() {
		return buy_count;
	}

	public void setBuy_count(int buy_count) {
		this.buy_count = buy_count;
	}

	public String getBook_image() {
		return book_image;
	}

	public void setBook_image(String book_image) {
		this.book_image = book_image;
	}

	@Override
	public String toString() {
		return "[cart_id=" + cart_id + ", buyer=" + buyer + ", book_id=" + book_id + ", book_title="
				+ book_title + ", buy_price=" + buy_price + ", buy_count=" + buy_count + ", book_image=" + book_image
				+ "]";
	}
	
	
}
