package bookstore.command;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bookstore.controller.CommandAction;
import bookstore.model.ManagerBean;
import bookstore.model.ManagerDAO;

public class _06_BookRegisterPro implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		request.setCharacterEncoding("UTF-8");

		String fileName = "";
		String realFolder = "";
		String saveFolder = "/bookImage"; 
		String encType = "UTF-8"; 
		int maxSize = 1 * 1024 * 1024; 

		MultipartRequest imageUp = null;

		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		System.out.println("realFolder = " + realFolder);

		try {
			
			imageUp = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());

			
			Enumeration<?> files = imageUp.getFileNames();

			
			while (files.hasMoreElements()) {
				
				String name = (String) files.nextElement(); // book_image

				
				fileName = imageUp.getFilesystemName(name);
				System.out.println("fileName = " + fileName);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		ManagerBean book = new ManagerBean();
		String book_kind = imageUp.getParameter("book_kind");
		String book_title = imageUp.getParameter("book_title");
		String book_price = imageUp.getParameter("book_price");
		String book_count = imageUp.getParameter("book_count");
		String author = imageUp.getParameter("author");
		String publishing_com = imageUp.getParameter("publishing_com");
		String book_content = imageUp.getParameter("book_content");
		String discount_rate = imageUp.getParameter("discount_rate");

		
		String year = imageUp.getParameter("publishing_year");
		String month = "";
		if (imageUp.getParameter("publishing_month").length() == 1) {
			month += "0" + imageUp.getParameter("publishing_month");
		} else {
			month = imageUp.getParameter("publishing_month");
		}
		String day = "";
		if (imageUp.getParameter("publishing_day").length() == 1) {
			day += "0" + imageUp.getParameter("publishing_day");
		} else {
			day = imageUp.getParameter("publishing_day");
		}

		book.setBook_kind(book_kind);
		book.setBook_title(book_title);
		book.setBook_price(Integer.parseInt(book_price));
		book.setBook_count(Integer.parseInt(book_count));
		book.setAuthor(author);
		book.setPublishing_com(publishing_com);
		book.setPublishing_date(year + "-" + month + "-" + day);

		if (fileName == null) {
			fileName = "nothing.jpg";
		}
		book.setBook_image(fileName);

		book.setBook_content(book_content);

		if (discount_rate.equals("")) {
			book.setDiscount_rate(10);
		} else {
			book.setDiscount_rate(Integer.parseInt(discount_rate));
		}

		ManagerDAO bookProcess = ManagerDAO.getInstance();
		int check = bookProcess.registedBookconfirm(book_kind, book_title, author);

		
		if (check == 1) {
			
			bookProcess.insertBook(book);
		}

		request.setAttribute("check", check);
		request.setAttribute("book_kind", book_kind);

		return "/08_bookRegisterPro.jsp";
	}

}
