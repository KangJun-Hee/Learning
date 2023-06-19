package com.green.board;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Date;
import java.util.ArrayList;

import _05_User.UserDTO;
	private BoardDAO() {}
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {return instance;}
	
	private static int idNum; //게시글 고유번호
	private ArrayList<BoardDTO> boardlist = new ArrayList<>();
	
	//(1)새 게시글을 저장해 주는 메서드
	public void boardWrite(BoardDTO board) {}
	
	
	// (1) 새 게시글을 저장해주는 메서드
	/* 아래 5개의 항목은 입력받을 수 없는 데이터로서
			 * 직접 값을 저장해줘야 한다.
			 * 
			 * ① 게시글 번호	: 마지막 게시글 번호에 1을 증가시킨다.
			 * ② 작성일		: Date클래스를 활용해 작성일자를 저장한다.
			 * ③ ref		: 새글의 ref는 현재 최대 ref값에 1을 증가시킨다.
			 * ④ reStep		: 새글의 reStep의 값은 1이다.
			 * ⑤ reLevel	: 새글의 reLevel의 값은 1이다.
			 */
	// (6) boardList를 리턴해주는 메서드
	// (7) 게시글 번호를 넘겨받으면 해당 게시글의 인덱스를 리턴해주는 메서드
	// (7) 게시글 번호를 넘겨받아 해당 게시글 정보를 리턴해주는 메서드(게시글 내용 확인하기)
	// (8) 게시글 번호를 넘겨받아 해당 게시글 정보를 리턴해주는 메서드(게시글 내용 수정하기)
	// (9) 게시글의 내용을(이메일,제목,내용) 수정해주는 메서드
	// (10) 게시글 삭제해주는 메서드 : 비밀번호가 일치하면 1을 불일치하면 -1을 리턴해준다.
}
