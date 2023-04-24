package BookMarket;

import java.util.ArrayList;
import com.market.bookitem.Book;

public class Cart implements CartInterface {

	public ArrayList<CartItem> mCartItem = new ArrayList<CartItem>();

//	static final int NUM_BOOK = 3;
//	public CartItem[] mCartItem = new CartItem[NUM_BOOK];
	public static int mCartCount = 0;

	public Cart() {

	}

	public void printBookList(ArrayList<Book> booklist) {
		/*
		 * for (int i = 0; i < booklist.length; i++) {
		 * System.out.print(booklist[i].getBookId() + " | ");
		 * System.out.print(booklist[i].getName() + " | ");
		 * System.out.print(booklist[i].getUnitPrice() + " | ");
		 * System.out.print(booklist[i].getAuthor() + " | ");
		 * System.out.print(booklist[i].getDescription() + " | ");
		 * System.out.print(booklist[i].getCategory() + " | ");
		 * System.out.print(booklist[i].getReleaseDate()); System.out.println(""); }
		 */
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
		// mCartItem[mCartCount++] = new CartItem(book);
		CartItem bookitem = new CartItem(book);
		mCartItem.add(bookitem);
		mCartCount = mCartItem.size();
	}

	public void deleteBook() {
		// mCartItem = new CartItem[NUM_BOOK];
		mCartItem.clear();
		mCartCount = 0;
	}

	public void printCart() {
		System.out.println("장바구니 상품 목록:");
		System.out.println("---------------------------------------------");
		System.out.println("    도서ID \t|     수량 \t|      합계");

		/*
		 * for (int i = 0; i < mCartCount; i++) { System.out.print("    " +
		 * mCartItem[i].getBookID() + " \t| "); System.out.print("    " +
		 * mCartItem[i].getQuantity() + " \t| "); System.out.print("    " +
		 * mCartItem[i].getTotalPrice()); System.out.println("  "); }
		 */

		for (int i = 0; i < mCartItem.size(); i++) { // 13
			System.out.print("    " + mCartItem.get(i).getBookID() + " \t| ");
			System.out.print("    " + mCartItem.get(i).getQuantity() + " \t| ");
			System.out.print("    " + mCartItem.get(i).getTotalPrice());
			System.out.println("  ");
		}

		System.out.println("---------------------------------------------");
	}

	public boolean isCartInBook(String bookId) {
		boolean flag = false;
		/*
		 * for (int i = 0; i < mCartCount; i++) { if (bookId ==
		 * mCartItem[i].getBookID()) {
		 * mCartItem[i].setQuantity(mCartItem[i].getQuantity() + 1); flag = true; } }
		 */
		for (int i = 0; i < mCartItem.size(); i++) {
			if (bookId.equals(mCartItem.get(i).getBookID())) {
				mCartItem.get(i).setQuantity(mCartItem.get(i).getQuantity() + 1);
				flag = true;
			}
		}
		return flag;
	}

	public void removeCart(int numId) {
		/*
		 * CartItem[] cartItem = new CartItem[NUM_BOOK]; int num = 0;
		 * 
		 * for (int i = 0; i < mCartCount; i++) if (numId != i) cartItem[num++] =
		 * mCartItem[i];
		 * 
		 * mCartCount = num; mCartItem = cartItem;
		 */
		mCartItem.remove(numId);
		mCartCount = mCartItem.size();
	}
}