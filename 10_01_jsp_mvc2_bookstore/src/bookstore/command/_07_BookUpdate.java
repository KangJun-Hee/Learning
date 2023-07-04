package bookstore.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.controller.CommandAction;
import bookstore.model.ManagerBean;
import bookstore.model.ManagerDAO;



public class _07_BookUpdate implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int book_id = Integer.parseInt(request.getParameter("book_id"));
		String book_kind = request.getParameter("book_kind");
		

		ManagerDAO bookProcess = ManagerDAO.getInstance();
		ManagerBean book =  bookProcess.getBook(book_id);
		
		request.setAttribute("book_id", book_id);
		request.setAttribute("book_kind", book_kind);
        request.setAttribute("book", book);
		request.setAttribute("type", new Integer(0));
		
		return "/09_bookUpdate.jsp";
	}

	
}
