package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddService;

public class AddHandler implements CommandHandler{

	private AddService addService = new AddService();
	
	@Override
	public String handlerAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int n1 = Integer.parseInt(request.getParameter("n1"));
		int n2 = Integer.parseInt(request.getParameter("n2"));
		
		int result = 0;
		// 파라메터값 가져오기 
		result = addService.add(n1, n2);
		// 더해서 처리하기 
		
		// 저장하는 공간이 필요하다.
		// request에 저장해서 보낼 것!
		request.setAttribute("result",result );
		return "/add.jsp";
	}

}
