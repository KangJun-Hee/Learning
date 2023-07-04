package bookstore.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.controller.CommandAction;
import bookstore.model.ManagerBean;
import bookstore.model.ManagerDAO;


public class _11_Main implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ManagerBean bookList[] = null;
		List<ManagerBean[]> bookLists = new ArrayList<ManagerBean[]>();

		
		ManagerDAO bookProcess = ManagerDAO.getInstance();
		for (int i = 1; i <= 3; i++) {
			bookList = bookProcess.getBooks(i + "00", 3);
			bookLists.add(bookList);
		}

		
		request.setAttribute("bookLists", bookLists);
		
		request.setAttribute("type", new Integer(1));

		return "/13_shopMain.jsp";
	}

}
