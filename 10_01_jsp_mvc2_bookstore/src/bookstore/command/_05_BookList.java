package bookstore.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.controller.CommandAction;
import bookstore.model.ManagerBean;
import bookstore.model.ManagerDAO;



public class _05_BookList implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String book_kind = request.getParameter("book_kind");
		if(book_kind == null) {
			book_kind = "all";
		}
		
		
		ManagerDAO bookProcess = ManagerDAO.getInstance();
		int count = bookProcess.getBookCount();
		
		
		if(count > 0) {
			
			List<ManagerBean> bookList = bookProcess.getBooks(book_kind);
			
			request.setAttribute("bookList", bookList);
		}
		
		
		request.setAttribute("count", new Integer(count));
		request.setAttribute("book_kind", book_kind);
		request.setAttribute("type", new Integer(0));
		
		return "/07_bookList.jsp";
	}

}
