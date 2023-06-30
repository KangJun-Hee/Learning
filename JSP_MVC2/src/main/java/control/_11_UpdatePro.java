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

@WebServlet("/updatePro.do")
public class _11_UpdatePro extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqPro(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqPro(req, resp);
	}

	public void reqPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		// id값 가져오기
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("memId");// 형변환 오브젝트->스트링
		
		String name = req.getParameter("name");
		String pw = req.getParameter("pw");
		
		String tel1 = req.getParameter("tel1");
		String tel2 = req.getParameter("tel2");
		String tel3 = req.getParameter("tel3");
		String tel = tel1+"-"+tel2+"-"+tel3;
		
		String email = req.getParameter("email");
		String field = req.getParameter("field");
		
		String[] arr = req.getParameterValues("skill");
		String skill = "";
		
		for(int i=0; i<arr.length; i++) {
			skill += arr[i];
			if(i != arr.length-1) {
				skill += ",";
			}
		}
		
		String major = req.getParameter("major");

		MemberDAO mdao = MemberDAO.getInstance();
		MemberBean bean = new MemberBean(id,pw,name,tel,email,field,skill,major);
		
		mdao.updateMember(id,bean);

		RequestDispatcher dis = req.getRequestDispatcher("10_update.jsp");
		dis.forward(req, resp);
	}
}