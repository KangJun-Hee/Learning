

import java.util.ArrayList;

import KH_ClassDiagram.Book;

public interface CartInterface {
	void printBookList(ArrayList<Book>p);
	
	boolean isCartInBook(String id);
	
	void insertBook(Book p);
	
	void removeCart(int numId);
	
	void deleteBook();
}
