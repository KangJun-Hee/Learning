package com.green.board;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BoardDAO {

	private BoardDAO() {}
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {return instance;}
	
	private static int idNum;   //게시글 고유 번호 
	private ArrayList<BoardDTO> boardlist = new ArrayList<>();
	
	// (1) 새 게시글을 저장해주는 메서드
	public void boardWrite(BoardDTO board) {
		
		/* 아래 5개의 항목은 입력받을 수 없는 데이터로서
		 * 직접 값을 저장해줘야 한다.
		 * 
		 * ① 게시글 번호	: 마지막 게시글 번호에 1을 증가시킨다.
		 * ② 작성일		: Date클래스를 활용해 작성일자를 저장한다.
		 * ③ ref		: 새글의 ref는 현재 최대 ref값에 1을 증가시킨다.
		 * ④ reStep		: 새글의 reStep의 값은 1이다.
		 * ⑤ reLevel	: 새글의 reLevel의 값은 1이다.
		 */
		
		// 게시글 고유번호를 증가시켜서 출력 0번부터 시작해서
		int num = BoardDAO.idNum +1;
		
		// 현재 날짜를 가지고와서 작성일 같이 표현 
		String regDate = getDate();
		
		int ref = getMaxOfRef() +1;
		int reStep =1;
		int reLevel =1;
		
		board.setNum(num);
		board.setRegDate(regDate);
		board.setReLevel(reLevel);
		board.setReStep(reStep);
		
		BoardDAO.idNum++;
		boardlist.add(board);		
		printBoardList();
		
	}
	
	// (2) 전체 게시글 수를 리턴해주는 메서드 
	public int getAllCount() {
		return boardlist.size();
	}
	
	// (3) 현재 날짜를 리턴해주는 메서드 
	public String getDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		return sdf.format(date);
	}
	// (4) 최대 ref 값을 리턴하는 메서드 
	public int getMaxOfRef() {
		int maxRef = 0;
		
		if(boardlist.size() != 0) {
			int lastIndex = boardlist.size() -1;
			maxRef = boardlist.get(lastIndex).getRef();
		}
		
		return maxRef;
	}
	
	
	//(5) 전체 게시글 내용을 출력해주는 메서드 -> 콘솔에서 검토용
	public void printBoardList() {
		for( BoardDTO temp : boardlist) {
			System.out.println(temp);
		}
		System.out.println("\n\n");
	}
	
	
	
	
	// (6) boardList를 리턴해주는 메서드
	public ArrayList<BoardDTO> getBoardList(){
		return boardlist;
	}
	
	// (7) 게시글 번호를 넘겨받아 해당 게시글 정보를 리턴해주는 메서드(게시글 내용 확인하기)
	public BoardDTO getBoardOfInfo(int num) {
		
		// 게시글 리스트에서 인덱스번호를 알아야된다. 
		int index = getBoardIndex(num);
		
		BoardDTO board = boardlist.get(index);
		// 게시글을 선택했기 때문에 조회수를 1증가 시킨다. 
		board.setReadCount(board.getReadCount() +1);		
		
		return board;
	}
	// (7) 게시글 번호를 넘겨받으면 해당 게시글의 인덱스를 리턴해주는 메서드
	public int getBoardIndex(int num) {
		int index = 0;
		for(int i = 0; i<boardlist.size(); i++) {
			if(boardlist.get(i).getNum() == num) {
				index = i;
			}
		}		
		return index;		
	}
	
	//(8)게시글 번호를 넘겨받아 해당게시글 정보를 리턴해 주는 메서드(게시글 내용 수정하기)
	public BoardDTO getBoardOfUpdate(int num) {
		int index = getBoardIndex(num);
		
		return boardlist.get(index);
	}
	
	//(9)게시글의 내용을(이메일,제목,내용) 수정하는 메서드
	public void boardUpdate(BoardDTO board) {
		int index = getBoardIndex(board.getNum());
		
		boardlist.get(index).setEmail(board.getEmail());
		boardlist.get(index).setSubject(board.getSubject());
		boardlist.get(index).setContent(board.getContent());
	}
	//(10)게시글 삭제하는 메서드:비번이 일치하면 1 불일치하면 -1을 리턴한다
	public int boardDelete(int num,String password) {
		int result = -1;
		
		int index = getBoardIndex(num);
		String dbPassword = boardlist.get(index).getPassword();
		
		if(dbPassword.equals(password)) {
			result = 1;
			
			boardlist.remove(index);
		}
		return result;
	}
	
	//(11)dummy file set
	public void setDummyData() {
		for(int i=0; i<10; i++) {
			int index = BoardDAO.idNum+1;
			
			BoardDTO board = new BoardDTO();
			board.setWriter("작성자"+index);
			board.setSubject("제목"+index);
			board.setEmail("e-mail"+index+"@naver.com");
			board.setPassword("1234");
			board.setContent("내용"+index);
			
			boardWrite(board);
		}
	}
	
	//(12)전체게시글 삭제
	public void boardClear() {
		boardlist.clear();
	}
	
	//(13)게시글목록 페이지수 
	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.setPerPageNum = perPageNum;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
