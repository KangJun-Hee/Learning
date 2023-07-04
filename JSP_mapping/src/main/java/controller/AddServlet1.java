package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet1 extends HttpServlet{
	@Override
	public void init() throws ServletException {
		System.out.println("초기화 및 생성 ");
	}
	@Override
	public void destroy() {
		System.out.println("소멸");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//  두개의 값을 받아서 더하는 기능 
	}
	
}
