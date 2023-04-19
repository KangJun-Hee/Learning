package KH_ClassDiagram;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import 
public class BookDAO {

	public void fileSave(Book[] aArr){

		try (ObjectOutputStream oj = new ObjectOutputStream
				(new FileOutputStream("book.txt"))) {
			for (Book b : aArr) {
				if (b != null) {
					oj.writeObject(b);
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
	}
	}
	public void fileRead() {
		ArrayList<Book> bookList = new ArrayList<>();
		
			try{
				ObjectInputStream in = new ObjectInputStream(new FileInputStream("book.txt"));
		while(true) {
			Book b = (Book)in.readObject();
			bookList.add(book);
		}
		}catch(EOFException e){
		
		}catch(IOException | ClassNotFoundException e){
			e.printStackTrace();
		}
		Book[] bArr = bookList.toArray(new Book[bookList.size()]);
		return bArr;
	}
}
