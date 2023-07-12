package com.kh.register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserRegisterCheck")
public class UserRegisterCheck extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqPro(req,resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqPro(req,resp);
	}

	protected void reqPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("UserRegisterCheck() 서블릿 연결 ");
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String userID = req.getParameter("userID").trim();
		System.out.println(userID);
		
		//DB로 연결할 때 service()랑 같은 역할함~
		//가입하려는 아이디가 테이블에 존재하는지 판단을 하는 메서드
		int result = new RegisterDAO().registerCheck(userID);
		
		//DB에서 결과를 받았다
		//클라이언트(ajax.js)한테 보내야 함~
		//서블릿으로 들어온 요청을 텍스트(html)형태로 응답을 보내려면 
		//printWriter클래스의 객체 이용해 getWriter()응답을 내보낼 수 있는
		//출력스트림을 얻는다
		resp.getWriter().write(result+"");//result숫자니까 문자로 바꿔준 거임
		
		//결과를  담아 ajax로 간다
	}	
	
	
	
	
	
	
}
//PrintWriter클래스
//바이트를 문자형태를 가지는 객체로 바꿔줌~
//클라이언트에게 문자형태로 응답하고 싶기에
//out(내보내기 위해) getWriter()메서드 통해 인스턴스 얻는다~

//서버가 문자열 보내는 응답정보 안에는 
//어떤 타입의 문서를 보낸다고 설정해 주는 부분 없다~
//웹브라우저는 기본값으로 처리함! 기본값:text/html이다~