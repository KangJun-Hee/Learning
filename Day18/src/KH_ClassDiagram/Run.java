package KH_ClassDiagram;

import java.io.File;

public class Run {

	public static void main(String[] args) {
		Book book = new Book();
		new BookMenu().mainMenu();
		BookController bc = new BookController();
		File newFile = new File("D:\\java_kjh\\javasrc\\Day18\\src\\KH_ClassDiagram\\book.txt");
		if(!newFile.exists()) newFile.createNewFile();
	}

}
