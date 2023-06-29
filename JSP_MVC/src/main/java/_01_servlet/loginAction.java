package _01_servlet;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginAction")
public class loginAction extends HttpServlet {
	
	// 대소문자 꼭 확인
//	@WebServlet("/loginAction") 주소값 
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		reqPro(request,response);
	}

	protected void reqPro(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
		// 실제 처리를 하는 메서드가 된다. 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		request.setAttribute("id",id);
		request.setAttribute("pw",pw);
		
		// 로그인을 유지하기 위해서 웹브러우저만 사용할 수 있도록 
		// session 저장 !
		
		
		RequestDispatcher dis = request.getRequestDispatcher
												("Servlet/02_loginView.jsp");
		
		dis.forward(request, response);
	}
		
	
}
