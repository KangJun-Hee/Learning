package bookstore.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.command._02_ManagerLoginPro;
import bookstore.command._01_ManagerMain;
import bookstore.command._03_ManagerLogout;
import bookstore.command._04_BookRegister;
import bookstore.command._05_BookList;
import bookstore.command._06_BookRegisterPro;
import bookstore.command._07_BookUpdate;
import bookstore.command._08_BookUpdatePro;
import bookstore.command._09_BookDeletePro;
import bookstore.command._10_Login;
import bookstore.command._11_Main;

@WebServlet(urlPatterns = { "*.do"})

public class Controller extends HttpServlet {

	private Map<String, Object> commandMap = new HashMap<String, Object>();	

	public void init() throws ServletException {	
		commandMap.put("/mg/main.do", new _01_ManagerMain());
		commandMap.put("/mg/loginPro.do", new _02_ManagerLoginPro());		
		commandMap.put("/mg/logout.do", new _03_ManagerLogout());
		commandMap.put("/mg/bookRegister.do", new _04_BookRegister());
		commandMap.put("/mg/bookList.do", new _05_BookList());
		commandMap.put("/mg/bookRegisterPro.do", new _06_BookRegisterPro());
		commandMap.put("/mg/bookUpdate.do", new _07_BookUpdate());
		commandMap.put("/mg/bookUpdatePro.do", new _08_BookUpdatePro());
		commandMap.put("/mg/bookDeletePro.do", new _09_BookDeletePro());
		commandMap.put("/login.do", new _10_Login());
		commandMap.put("/main.do", new _11_Main());
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		requestPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestPro(request, response);
	}
	private void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String view = "";
		CommandAction com = null;
		try {
			String command = request.getRequestURI();
			if(command.indexOf(request.getContextPath()) == 0) {
				command = command.substring(request.getContextPath().length());
			}
			com = (CommandAction)commandMap.get(command);
			view = com.requestPro(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("cont", view);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/00_index.jsp");
		dispatcher.forward(request, response);
			
	}
}
