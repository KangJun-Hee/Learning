
package bookstore;

public class BookDTO {
	private int book_id;			// 책 등록번호
	private String book_kind;		// 책 분류
	private String book_title;		// 책 이름
	private int book_price;			// 책 가격
	private int book_count;			// 책 재고수량
	private String author;			// 책 저자
	private String publishing_com;	// 출판사
	private String publishing_date;	// 출판일
	private String book_image;		// 책 이미지명
	private String book_content;	// 책 내용
	private int discount_rate;		// 책 할인율
	private String reg_date;		// 책 등록날짜
	
		
	
	public BookDTO() {
		super();
	}

	public BookDTO(int book_id, String book_kind, String book_title, int book_price, int book_count, String author,
			String publishing_com, String publishing_date, String book_image, String book_content, int discount_rate,
			String reg_date) {
		super();
		this.book_id = book_id;
		this.book_kind = book_kind;
		this.book_title = book_title;
		this.book_price = book_price;
		this.book_count = book_count;
		this.author = author;
		this.publishing_com = publishing_com;
		this.publishing_date = publishing_date;
		this.book_image = book_image;
		this.book_content = book_content;
		this.discount_rate = discount_rate;
		this.reg_date = reg_date;
	}

	

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_kind() {
		return book_kind;
	}

	public void setBook_kind(String book_kind) {
		this.book_kind = book_kind;
	}

	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public int getBook_price() {
		return book_price;
	}

	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}

	public int getBook_count() {
		return book_count;
	}

	public void setBook_count(int book_count) {
		this.book_count = book_count;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishing_com() {
		return publishing_com;
	}

	public void setPublishing_com(String publishing_com) {
		this.publishing_com = publishing_com;
	}

	public String getPublishing_date() {
		return publishing_date;
	}

	public void setPublishing_date(String publishing_date) {
		this.publishing_date = publishing_date;
	}

	public String getBook_image() {
		return book_image;
	}

	public void setBook_image(String book_image) {
		this.book_image = book_image;
	}

	public String getBook_content() {
		return book_content;
	}

	public void setBook_content(String book_content) {
		this.book_content = book_content;
	}

	public int getDiscount_rate() {
		return discount_rate;
	}

	public void setDiscount_rate(int discount_rate) {
		this.discount_rate = discount_rate;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return " [book_id=" + book_id + ", book_kind=" + book_kind + ", book_title=" + book_title
				+ ", book_price=" + book_price + ", book_count=" + book_count + ", author=" + author
				+ ", publishing_com=" + publishing_com + ", publishing_date=" + publishing_date + ", book_image="
				+ book_image + ", book_content=" + book_content + ", discount_rate=" + discount_rate + ", reg_date="
				+ reg_date + "]";
	}
	
	
	
	
	
	
	
	
}
