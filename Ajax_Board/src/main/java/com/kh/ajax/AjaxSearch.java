package com.kh.ajax;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AjaxSearch")
public class AjaxSearch extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		actionDo(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		actionDo(req,resp);
	}
	
	protected void actionDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("AjaxSearch서블릿의 actionDo() 메서드 실행 ");
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String name = req.getParameter("name");
		
		// ajax 방식으로 요청한 곳으로 데이터를 리턴한다. 
		// ajax로 서블릿으로 호출한 곳에서 responseText를 사용해서 받는다. 
		// write(): ajax 방식으로 요청한 곳으로 데이터를 리턴한다. 
		// 인수는 반드시 문자열이어야 한다. 
		resp.getWriter().write(getJSON(name));
		
		
	}
	private String getJSON(String name) {
		System.out.println("getJson메서드()");
		// 검색할 이름을 입력하지 않고 검색 버튼을 눌렀을 때 null을 공백처리한다.
		if(name == null) {name ="";}
		
		// 테이블에서 입력한 문자열이 name 필드에 포함 된 데이터를 얻어온다. 
		ArrayList<AjaxDTO> list = new AjaxDAO().search(name);
		
		// 테이블에서 검색해 얻어온 데이터를 json 형식의 문자열로 만든다.
		StringBuffer result = new StringBuffer();
		result.append("{\"result\":[");  //json시작
		// 데이터의 개수만큼 반복하며 json형태의 문자열을 만든다. 
		for (AjaxDTO vo : list) {
			result.append("[{\"value\": \"" + vo.getIdx() + "\"},");
			result.append("{\"value\": \"" + vo.getName().trim() + "\"},");
			result.append("{\"value\": \"" + vo.getAge() + "\"},");
			result.append("{\"value\": \"" + vo.getGender().trim() + "\"},");
			result.append("{\"value\": \"" + vo.getEmail() + "\"}],");
		}
		result.append("]}"); // json 끝
		
		// StringBuffer 타입의 객체를 String 타입으로 리턴시키기 위해서 toString()메서드를
		// 실행시켜서 리턴한다. 
		return result.toString();
		
		/*
		 *  { "key" : "value", "key":"vale"  }
		 * 
		 * 
		 */
		
		
	}
	
	
	
	
	
	
}





