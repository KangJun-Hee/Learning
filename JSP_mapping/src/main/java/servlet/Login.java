package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 하나의 서블릿에 매핑으로 여러개 배열 형식으로 선언 
// @WebServlet(urlPatterns={"/main","/test","/join"})
// @WebServlet(urlPattern="/first")
//@WebServlet("/Login")
public class Login extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("매핑성공! 서블릿안으로 들어왓따!");
		
		
//		String id = req.getParameter("id");
//		String pw = req.getParameter("pw");
//		
//		
//		req.setAttribute("id", id);
//		req.setAttribute("pw", pw);
//		
//				
//		
		RequestDispatcher dis = req.getRequestDispatcher("LoginView.jsp");	
		dis.forward(req, resp);	
		
	}
	// 서블릿 초기화하는 메서드 오버라이딩 
	@Override
	public void init() throws ServletException {
		System.out.println("서블릿초기화!");
	}
	
	// 서블릿은 main함수가 없다! 그래서 메인함수 대신 service함수가 main함수의 역할을 한다.
	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//	}

}
