package KH_ClassDiagram;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Book {
	
	String title;
	String author;
	int price;
	Calendar date;
	double discount;
	
	public Book() {}
	public Book(String title, String author, int price, Calendar date, double discount) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.date = date;
		this.discount = discount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년  MM월 dd일");
		String strNowDate = simpleDateFormat.format(date);
		return "Book [title=" + title + ", author=" + author + ", price=" + price + ", date=" + simpleDateFormat.format(date) + ", discount="
				+ discount + "]";
	}

}
