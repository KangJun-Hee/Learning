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

//url applyPro.do
//1.form으로 넘어온 데이터들을
@WebServlet("/applyPro.do")
public class _08_ApplyPro extends HttpServlet {
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

		// 추가적으로 입력되는 정보들만 꺼내온다. 폼태그에서 받은 객체 안에서
		String field = req.getParameter("field");
		String[] skill = req.getParameterValues("skill");
		
		//각각의 체크내용을 문자열로 연결해 한꺼번에 저장!
		String skill2 = "";
		for(int i=0; i<skill.length; i++) {
			skill2+=skill[i];
			
			if(i != skill.length-1) {
				skill2+=",";
			}
		}
		
		String major = req.getParameter("major");
		
		MemberDAO mdao = MemberDAO.getInstance();
		mdao.apply(id,field,skill2,major);
		

		RequestDispatcher dis = req.getRequestDispatcher("08_applyView.jsp");
		dis.forward(req, resp);
	}
}
