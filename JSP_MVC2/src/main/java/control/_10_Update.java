package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberBean;
import model.MemberDAO;

@WebServlet("/update.do")
public class _10_Update extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqPro(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqPro(req, resp);
	}

	public void reqPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// id값 가져오기
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("memId");// 형변환 오브젝트->스트링

		MemberDAO mdao = MemberDAO.getInstance();
		MemberBean bean = mdao.getOneMember(id);

		RequestDispatcher dis = req.getRequestDispatcher("10_update.jsp");
		dis.forward(req, resp);
	}
}