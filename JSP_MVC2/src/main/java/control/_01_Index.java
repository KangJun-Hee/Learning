package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// control 폴더 안에 서블릿들을 모아놓았다. 
// mcv2 구조 

@WebServlet("/index.do")

public class _01_Index extends HttpServlet{
	// 서블릿으로 만들 것!
	// 1. 로그인을 하면 데이터를 추가!
	//   여러페이지에서 공유 ! session 영역에 id저장
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqPro(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqPro(req,resp);
	}
	protected void reqPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("memId");
		
		req.setAttribute("id", session);
		
		RequestDispatcher dis = req.getRequestDispatcher("01_index.jsp");
		dis.forward(req, resp);
		
		
	}
}
