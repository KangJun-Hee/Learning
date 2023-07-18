package com.kh.springWeb_board.board;

public class Board {
	private int num;
	private String writer;
	private String email;
	private String subject;
	private String password;
	private String reg_date;
	private String ref;
	private String re_step;
	private String re_level;
	private String readcount;
	private String content;
	public Board(int num, String writer, String email, String subject, String password, String reg_date, String ref,
			String re_step, String re_level, String readcount, String content) {
		super();
		this.num = num;
		this.writer = writer;
		this.email = email;
		this.subject = subject;
		this.password = password;
		this.reg_date = reg_date;
		this.ref = ref;
		this.re_step = re_step;
		this.re_level = re_level;
		this.readcount = readcount;
		this.content = content;
	}
	
	
}
