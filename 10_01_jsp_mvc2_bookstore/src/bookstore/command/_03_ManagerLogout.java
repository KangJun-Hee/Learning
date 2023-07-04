package bookstore.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookstore.controller.CommandAction;



public class _03_ManagerLogout implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		session.invalidate();
		
		return "/05_managerLogout.jsp";
	}

}
