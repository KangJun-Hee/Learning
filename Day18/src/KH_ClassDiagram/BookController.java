package KH_ClassDiagram;

import java.io.IOException;

public class BookController {

	public void makeFile() {
		new File("book.txt");
	}

	public Book[] fileRead() {
		bd = new BookDAO();
		try {
			makeFile();
			bArr = fileRead();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
