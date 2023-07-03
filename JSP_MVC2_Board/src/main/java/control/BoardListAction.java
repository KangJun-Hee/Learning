package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Currency;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardBean;
import model.BoardDAO;

@WebServlet("/BoardListAction")
public class BoardListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BoardListAction() {  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		reqPro(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		reqPro(request,response);
	}
	public void reqPro(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
		
		// 화면에 보여질 게시글의 개수를 지정 
		int pageSize = 10;
		// 현재 보여지고 있는 페이지의 number 값을 읽어드림
		String pageNumber = request.getParameter("pageNum");
		
		// null처리 
		if(pageNumber == null) {
			pageNumber = "1";
		}
		
		// 전체 게시글의 개수 
		int count = 0;
		
		// jsp 페이지 내에서 보여질 숫자 값을 저장하는 변수 선언 
		int number = 0;
		
		// 현재 보여지고 있는 페이지 문자를 숫자로 형변환 
		int currentPage = Integer.parseInt(pageNumber);
		
		
		// pageNum 지금 내가 몇 페이지에 있는지 확인함 
		// 전체 게시글의 개수를 가져와야 하기에 데이터베이스 객체 생성 
		// BoardDAO 객체 안에서 연동, getAllcount();
		
		BoardDAO bdao = BoardDAO.getInstance();
		count = bdao.getAllCount();
		
		
		// 현재 보여질 페이지 시작 번호를 설정 
		int startRow = (currentPage - 1) * pageSize;
		
		
		// 최신글 10개를 기준으로 게시글을 리턴 받아 주는 메서드를 호출
		// DAO => getAllBoard(); 리턴 매개변수 startRow , pageSize;
		ArrayList<BoardBean> list = bdao.getAllBoard(startRow, pageSize);
		
		// request객체에 저장 
		// 최신 게시글 , number, pageSize,count, currentPage
		number = count - (currentPage -1) * pageSize;
	
		// RequestDispatcher  페이지 호출없이 jsp파일 내에서  다른 파일 요청을 보내고
		//					 바로 응답 받는다. 
		// sendRedirect  브라우저가 response 에 따라 서버로 지정된 경로를 
		//               다시 요청하여 페이지를 호출 한다. 
		
		
		request.setAttribute("list", list);
		request.setAttribute("number", number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);
	
		
		RequestDispatcher dis = request.getRequestDispatcher("02_boardList.jsp");
		dis.forward(request, response);
		
		
	}
}
