package BookMarket;

import java.util.ArrayList;
import com.market.bookitem.Book;

public interface CartInterface {
	void printBookList(ArrayList<Book> p);

	boolean isCartInBook(String id);

	void insertBook(Book p);

	void removeCart(int numId);

	void deleteBook();
}