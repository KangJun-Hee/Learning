package bookstore.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.controller.CommandAction;



public class _01_ManagerMain implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			
		request.setAttribute("type", 0);		
		return "/02_managerMain.jsp";
	}
}