package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardBean;
import model.BoardDAO;

@WebServlet("/ReWriteAction")
public class ReWriteAction extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	public void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDAO bdao = BoardDAO.getInstance();
		BoardBean bean = bdao.getOneBoard(num);
		
		// 현재 글 번호로 댓글그룹의 번호로 지정한다. 
		int ref = bean.getRef();
		int re_step = bean.getRe_step();
		int re_level = bean.getRe_level();
		
		System.out.println("Ref : "+ ref);
		
		request.setAttribute("ref",ref);
		request.setAttribute("re_step",re_step);
		request.setAttribute("re_level",re_level);
		
		
		
		RequestDispatcher dis = request.getRequestDispatcher("04_reWrite.jsp");
		dis.forward(request, response);
	}
	
	
}
