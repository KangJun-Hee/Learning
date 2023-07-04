package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

	
	// 들어온 url의 주소가 /add /min 
	// 서블릿들의 내용을 저장해서 가지고 있어야된다. 
	private Map<String, CommandHandler> commandHandlerMap = new HashMap<>();
	
	// 초기화할 때 
	@Override
	public void init() throws ServletException {
		
		commandHandlerMap.put("/add",new AddHandler());
		commandHandlerMap.put("/min",new MinHandler());
		commandHandlerMap.put("/", new AddHandler());
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		System.out.println("컨트롤러가 요청을 분석중!");
		
		String requestURL = req.getRequestURI().toString();
		System.out.println("요청 url :" + requestURL);

		String command = requestURL.substring(req.getContextPath().length());
		System.out.println("command:" + command);

		// 경로를 찾아서 저장 
		// 처리를 하면 어디다가 보여줄 지 저장하는 변수 
		
		CommandHandler handler = null;
		String viewPage = null;
		
		if(requestURL.indexOf(req.getContextPath())==0) {
			handler = commandHandlerMap.get(command);
			viewPage = handler.handlerAction(req, resp);
			System.out.println("모델과 관련된 비지니스로직 동작!");
		}
		System.out.println("뷰 페이지로 포워딩!");
		req.getRequestDispatcher(viewPage).forward(req, resp);
	}
	
	
	
	
}
