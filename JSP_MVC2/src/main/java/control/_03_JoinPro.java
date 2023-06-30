package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/joinPro.do")
public class _03_JoinPro extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqPro(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqPro(req,resp);
	}
	protected void reqPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		// form에서 보내온 정도를 꺼내기
		
		// MemberBean 생성해서  멤버들을 관리하는 DAO
		
		
		RequestDispatcher dis = req.getRequestDispatcher("01_index.jsp");
		dis.forward(req, resp);
		
		
	}
	
}
