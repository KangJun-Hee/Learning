package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet 어노테이션에 특정요청을 써주면 그 요청이 들어왔을 때 컨트롤러의
//메서드가 자동으로 실행된다

//@WebServlet 어노테이션에 특정 요청 해당컨트롤러의 메서드가 실행되므로 요청마다
//컨트롤러를 일일이 만들어야 하는 문제점이 발생함~

//@WebServlet 어노테이션에 와일드카드 문자(*)를 사용하는 확장명 패턴의 요청을 받을 수
//있다.
//확장명 패턴 방식으로 요청을 받을 때만! 앞에 "/"를 붙이지 않는다~
//

@WebServlet("*.nhn")
public class HomeController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		actionDo(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		actionDo(req,resp);
	}
	protected void actionDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//한글깨짐
		req.setCharacterEncoding("utf-8");//받을 때 
		resp.setContentType("text/html; charset=utf-8");//보낼 때
		
		//getRequestURI()메서드로 주소창에 요청된 컨텍스트패스와 요청을 받는다~
		//	/JSP_MVC_INF2/main.nhn
		String url = req.getRequestURI();
		System.out.println(url);
		
		//getContextPath()메서드로 주소창에 요청된 컨텍스트패스만 받아온다
		String contextPath = req.getContextPath();
		System.out.println(contextPath);
		
		//주소창에 입력된 컨텍스트 패스 뒤의 요청만 얻어온다
		//지정된 숫자 다음부터 끝까지 문자열을 잘라 가지고 온다
																//이러면 .nhn을 자르고 home만 나올 수 잇다~
		String context = url.substring(contextPath.length()+1,url.length()-4);
		System.out.println(context);
		
		//파일명.nhn
		//파일명만 가져와 context 다시 저장
		
		//요청페이지에 따라 view만 결정한다~
		String viewpage = "/WEB-INF/";
		
		switch (context) {
		case "home":
			viewpage += "home"; //"/WEB-INF/" + "home" => "/WEB-INF/home"
			
			break;
			
		case "index":
			viewpage += "index"; //"/WEB-INF/" + "home" => "/WEB-INF/home"
			
			break;
		}
		
		//확장자를 붙이는 작업
		viewpage += ".jsp";//"/WEB-INF/" + ".jsp"   =>   "/WEB-INF/home.jsp"
		
		//요청에 따른 페이지를 호출한다
		RequestDispatcher dis = req.getRequestDispatcher(viewpage);
		dis.forward(req, resp);

	}
}




















