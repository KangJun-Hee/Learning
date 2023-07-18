package com.kh.springWeb_board;

public class Member {
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
	
	public Member() {}
	public Member(int num, String writer, String email, String subject, String password, String reg_date, String ref,
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getRe_step() {
		return re_step;
	}
	public void setRe_step(String re_step) {
		this.re_step = re_step;
	}
	public String getRe_level() {
		return re_level;
	}
	public void setRe_level(String re_level) {
		this.re_level = re_level;
	}
	public String getReadcount() {
		return readcount;
	}
	public void setReadcount(String readcount) {
		this.readcount = readcount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Member [num=" + num + ", writer=" + writer + ", email=" + email + ", subject=" + subject + ", password="
				+ password + ", reg_date=" + reg_date + ", ref=" + ref + ", re_step=" + re_step + ", re_level="
				+ re_level + ", readcount=" + readcount + ", content=" + content + "]";
	}
	
	
		
	
}
