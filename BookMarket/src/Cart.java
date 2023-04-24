import java.awt.print.Book;
import java.util.ArrayList;

public class Cart implements CartInterface {

	public ArrayList<CartItem> mCartItem = new ArrayList<>();

	static final int NUM_BOOK = 3;
	public CartItem[] mCartItem = new CartItem[NUM_BOOK];
	static int mCartCount = 0;

	public Cart() {
	}

	public void printBookList(ArrayList<Book> booklist) {
//		for(int i=0; i<booklist.length; i++) {
//			System.out.println(booklist[i].getBookId() + " | ");
//			System.out.println(booklist[i].getName() + " | ");
//			System.out.println(booklist[i].getUnitPrice() + " | ");
//			System.out.println(booklist[i].getAuthor() + " | ");
//			System.out.println(booklist[i].getDescription() + " | ");
//			System.out.println(booklist[i].getCategory() + " | ");
//			System.out.println(booklist[i].getReleaseDay() + " | ");
//			System.out.println("");

		for (int i = 0; i < booklist.size(); i++) {
			Book bookitem = booklist.get(i);
			System.out.print(bookitem.getBookId() + " | ");
			System.out.print(bookitem.getName() + " | ");
			System.out.print(bookitem.getUnitPrice() + " | ");
			System.out.print(bookitem.getAuthor() + " | ");
			System.out.print(bookitem.getDescription() + " | ");
			System.out.print(bookitem.getCategory() + " | ");
			System.out.print(bookitem.getReleaseDate());
			System.out.println("");
		}
	}
	
	public void insertBook(Book book) {
		//mCartItem[mCartCount++] = new CartItem(book);
		CartItem bookitem = new CartItem(book);
		mCartItem.add(bookitem);
		mCartCount = mCartItem.size();
	}
	
	public void deleteBook() {
		//mCartItem = new CartItem[NUM_BOOK];
		mCartItem.clear();
		mCartCount = 0;
	}
	public void printCart() {
		System.out.println("장바구니 상품 목록:");
		System.out.println("--------------------------");
		System.out.println("     도서ID \t|     수량\t|        합계");
		
		/*
		 * for (int i = 0; i < mCartCount; i++) { System.out.print("    " +
		 * mCartItem[i].getBookID() + " \t| "); System.out.print("    " +
		 * mCartItem[i].getQuantity() + " \t| "); System.out.print("    " +
		 * mCartItem[i].getTotalPrice()); System.out.println("  "); }
		 */
		for(int i = 0; i<mCartItem.size(); i++) {//13
			System.out.println("     " + mCartItem.get(i).getBookID()+"  \t|");
			System.out.println("     " + mCartItem.get(i).getQuantity()+"  \t|");
			System.out.println("     " + mCartItem.get(i).getTotalPrive()+"  \t|");
			System.out.println("     ");
		}
		System.out.println("------------------------");
	}
	public boolean isCartInBook(String bookId) {
		boolean flag = false;
		/*
		 * for(int i = 0; i<mCartCount; i++){ if (bookId ==
		 * mCartItem[i].getBookID()) {
		 * mCartItem[i].setQuantity(mCartItem[i].getQuantity() + 1); flag = true;} }
		 * 
		 */
		for(int i=0; i<mCartItem.size(); i++) {
			if(bookId.equals(mCartItem.get(i).getBookID())) {
				mCartItem.get(i).setQuantity(mCartItem.get(i).getQuantity()+1);
				flag = true;
			}
		}
		return flag;
	}
	
	public void removeCart(int numId) {
		/*
		 * CartItem[] cartItem = new CartItem[NUM_BOOK]; int num = 0;
		 * 
		 * for(int i=0; i<mCartCount; i++) if(numId != i) cartItem[num++] =
		 * mCartItem[i];
		 * 
		 * mCartCount = num; mCartItem = cartItem;
		 */
		mCartItem.remove(numId);
		mCartCount = mCartItem.size();
	}
	
	
	
	
	
	
	
	String[] itemBook = new String[7];

	private String bookID;
	private String title;
	private String author;
	private int price;

	String[] itemBook1 = { "ISBN1234", "쉽게 배우는 JSP 웹 프로그래밍", "27000", "송미영", "단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍", "IT전문서",
			"2018/10/08" };
	String[] itemBook2 = { "ISBN1235", "안드로이드 프로그래밍", "33000", "우재남", "실습 단계별 명쾌한 멘토링!", "IT전문서", "2022/01/22" };
	String[] itemBook3 = { "ISBN220913101957", "스크래치", "22000", "고광일", "컴퓨팅 사고력을 키우는 블록 코딩", "컴퓨터입문", "2019/06/10" };

}
