package bookstore.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.controller.CommandAction;
import bookstore.model.ManagerDAO;



public class _09_BookDeletePro implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int book_id = Integer.parseInt(request.getParameter("book_id"));
		String book_kind = request.getParameter("book_kind");
		
		
		ManagerDAO bookProcess = ManagerDAO.getInstance();
		bookProcess.deleteBook(book_id); 
		
		request.setAttribute("book_kind", book_kind);
		
		return "/11_bookDeletePro.jsp";
	}

}
