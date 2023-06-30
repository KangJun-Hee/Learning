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

@WebServlet("/apply.do")
public class _07_Apply extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqPro(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqPro(req,resp);
	}
	public void reqPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//id값 가져오기
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("memId");//형변환 오브젝트->스트링
		
		if(id!=null) {
			//1.아이디값 이용해 데이터베이스에서 찾아 결과를 저장!
			MemberDAO mdao = MemberDAO.getInstance();
			MemberBean bean = mdao.getOneMember(id);
			
			String tel = bean.getTel();
			String[] arr = tel.split("-");
			String tel1 = arr[0];
			String tel2 = arr[1];
			String tel3 = arr[2];
			
			req.setAttribute("tel1", tel1);
			req.setAttribute("tel2", tel2);
			req.setAttribute("tel3", tel3);
			req.setAttribute("bean", bean);
		}
		RequestDispatcher dis = req.getRequestDispatcher("07_apply.jsp");
		dis.forward(req,resp);
	}
}
