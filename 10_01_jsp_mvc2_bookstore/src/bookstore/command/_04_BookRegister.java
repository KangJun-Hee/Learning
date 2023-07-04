package bookstore.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.controller.CommandAction;



public class _04_BookRegister implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setAttribute("type", 0);
		return "/06_bookRegister.jsp";
	}

}
