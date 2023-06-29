package _02_practice;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test03")
public class Test01 extends HttpServlet{

	int num;
	
	public Test01(int num) {
		this.num = num;
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqPro(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqPro(req,resp);
	}
	
	protected void reqPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 국어 영어 수학 입력
		// 2. 평균  70점 이상이면 합격 저장 불합격 
		// 3. 각각의 저장해야되는 내용들을 내장객체인 변수들에 저장해서 
		// 4. 01_baiscView 출력 되면 됩니다.
		
		Test01 n = new Test01(10);
		
		req.setAttribute("list",n);
		
		RequestDispatcher dis = req.getRequestDispatcher("practice/03_basicView.jsp");
		dis.forward(req, resp);
		
		
	}
	
	
	
	
}
