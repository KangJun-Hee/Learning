package com.kh.register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		reqPro(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqPro(req, resp);
	}

	protected void reqPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("UserRegister() 서블릿 연결 ");

		 System.out.println("UserRegister 서블릿의 actionDo() 메소드 실행");
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset=UTF-8");
			
			String userID = req.getParameter("userID").trim();
			String userPassword1 = req.getParameter("userPassword1").trim();
			String userPassword2 = req.getParameter("userPassword2").trim();
			String userName = req.getParameter("userName").trim();
			String userAge = req.getParameter("userAge").trim();
			String userGender = req.getParameter("userGender");
			String userEmail = req.getParameter("userEmail").trim();
			
			if (userID == null || userID.equals("") ||
				userPassword1 == null || userPassword1.equals("") ||
				userPassword2 == null || userPassword2.equals("") ||
				userName == null || userName.equals("") ||
				userAge == null || userAge.equals("") ||
				userGender == null || userGender.equals("") ||
				userEmail == null || userEmail.equals("")) {
			
				resp.getWriter().write("1"); // ②
				return;
			}
			
			boolean res = !userPassword1.equals(userPassword2);
			//false가 나왔단 건 비번 두 개가 일치하는 것~
			//true는 비번 둘이 다르다는 뜻
			System.out.println("if문 전 비번결과:"+res);
			if(res) {
				resp.getWriter().write("2");
				return;
			}
			if (!userPassword1.equals(userPassword2)) {
			
				resp.getWriter().write("2"); // ②
				return;
			}
			
			RegisterDTO vo = new RegisterDTO(userID, userPassword2, userName
					, Integer.parseInt(userAge), 
					userGender, userEmail);
			
			int result = new RegisterDAO().register(vo);
			
			
			if (result == 1) {
				
				resp.getWriter().write("3"); // ②
			} else {
			
				resp.getWriter().write("4"); // ②
			}	
	}
}







