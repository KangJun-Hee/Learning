package com.kh.springWeb_board.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	@Autowired // 자동으로 객체생성
	BoardDAO dao;

	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest req) {
		return req.getContextPath();// 프로젝트주소값을 cp에 리턴
	}

	@RequestMapping("/board/boardList")
	public String boardList(HttpServletRequest req, Model model) {
		System.out.println("---boardList()---");

		// 한페이지에 몇개씩 보여줄지
		int pageSize = 3;

		int currentPage = 1;
		if (req.getParameter("pageNum") != null) {
			currentPage = Integer.parseInt(req.getParameter("pageNum"));
		}

		// 게시글의 개수 갖고오는 내용 실행하는 DB연결
		int count = dao.getAllCount();

		// 글 시작번호 알려줘야 한다
		int startRow = (currentPage - 1) * pageSize;

		// mysql은 limit, 오라클은 끝나는 번호 넘겨주고
		ArrayList<Board> boardList = dao.getAllBoard(startRow, pageSize);

		int number = 0;
		int clickablePageCount = 5;
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1); // 총페이지수 계산하는 명령문 60/5 -> 12
		int startPage = 0;
		int endPage = 0;

		// 위의 수식 작성해야 게시글목록 나옴

		model.addAttribute("boardList", boardList);
		model.addAttribute("currentList", currentList);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pageCount", pageCount);

		return "board/boardList";// 뷰페이지 설정jsp
	}

	@RequestMapping("/board/boardInfo")
	public String boardInfo(HttpServletRequest req, Model model) {
		return null;
	}

	@RequestMapping("/board/boardWriteForm")
	public String boardWriteForm() {
		//글쓰기로 넘어가는 뷰로 연결만 해 주면 된다
		return "board/boardWriteForm";
	}

	@RequestMapping(value="/board/boardWritePro",method=RequestMethod.POST)
	public String boardWritePro(Model model, Board board) {
		//spring이 자동으로 매핑을 시켜 준다, 필드명과 Board클래스의 필드명이 꼭 맞아야 실행됨~
		dao.insertBoard(board);
		model.addAttribute("board",board);
		
		return "redirect:/board/boardList";		
	}
	
	@RequestMapping("/board/reWriteForm")
	public String reWriteForm(HttpServletRequest req, Model model) {
		//답글다는 글번호 꺼내온다
		int num = Integer.parseInt(req.getParameter("num"));
		
		//글의 정보를 가지고 와서 그 글의 번호 (그룹, 댓글, 대댓글 구별하는 변수들)
		//ref글 그룹번호, step 댓글번호 ,level들여쓰기
		Board board = dao.getOneBoard(num);
		
		model.addAttribute("ref",board.getRef());
		model.addAttribute("re_step",board.getRe_step());
		model.addAttribute("re_level",board.getRe_level());
		
		return "board/reWriteForm";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
