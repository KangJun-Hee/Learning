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

@WebServlet("/ReWriteProAction")
public class ReWriteProAction extends HttpServlet {

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
			
		bean.setWriter(request.getParameter("writer"));
		bean.setSubject(request.getParameter("subject"));
		bean.setEmail(request.getParameter("email"));
		bean.setPassword(request.getParameter("password"));
		bean.setContent(request.getParameter("content"));

		
		// 댓글에 관한 변수들을 추가해야된다. 
		// 현재 게시글의 정보를 가지고 온다. reWriteAction 현재 선택된 게시글의
		// 정보를 가지고 04파일로 갔다가 거기서 답글완료를 누르는 순간 
		// pro와서 거기에 새로운 내용으로 객체를 생성해서 
		// 데이터베이스엥 업그레이드 한다. 
		
		bean.setRef(Integer.parseInt(request.getParameter("ref")));
		bean.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		bean.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		
		
		BoardDAO.getInstance().reWriteBoard(bean);

		RequestDispatcher dis = request.getRequestDispatcher("BoardListAction");
		dis.forward(request, response);
	}
}
