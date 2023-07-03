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

@WebServlet("/UpdateActionPro")
public class UpdateActionPro extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		reqPro(request, response);
	}

	public void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 한글 깨짐 처리 
		request.setCharacterEncoding("utf-8");
		
		BoardBean bean = new BoardBean();
		System.out.println(request.getParameter("num"));
		
		bean.setNum(Integer.parseInt(request.getParameter("num")));
		bean.setWriter(request.getParameter("writer"));
		bean.setSubject(request.getParameter("subject"));
		bean.setEmail(request.getParameter("email"));
		bean.setPassword(request.getParameter("password"));
		bean.setContent(request.getParameter("content"));
		
				
		BoardDAO bdao = BoardDAO.getInstance();
		bdao.updateBoard(bean);
		
		RequestDispatcher dis = request.getRequestDispatcher("BoardListAction");
		dis.forward(request, response);
	}

}
