package bookstore.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bookstore.controller.CommandAction;
import bookstore.model.ManagerDAO;


public class _02_ManagerLoginPro implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		// 넘어온 데이터 저장
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		// db연동 : 사용자 인증처리
		ManagerDAO bookProcess = ManagerDAO.getInstance();
		int check = bookProcess.userCheck(id, passwd);
		
		if(check == 1) {
			// 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("mngId", id);
		}
		
		request.setAttribute("check", check);
		request.setAttribute("id", id);
		
		return "/03_managerLoginPro.jsp";
	}

}
