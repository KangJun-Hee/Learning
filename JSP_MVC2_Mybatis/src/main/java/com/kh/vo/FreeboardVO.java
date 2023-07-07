package com.kh.vo;

import java.util.Date;

// 메인 글 1건을 기억하는 클래스 
public class FreeboardVO {

	private int idx;
	private String name;
	private String password;
	private String subject; // 글제목
	private String content; // 글내용
	private Date writeDate;
	private int hit; // 조회수
	private String notice = "no"; // 공지글 여부(yes => 공지글, no => 일반글)
	private String ip;
	private int commentCount; // 댓글의 개수
	public FreeboardVO(int idx, String name, String password, String subject, String content, Date writeDate, int hit,
			String notice, String ip, int commentCount) {
		super();
		this.idx = idx;
		this.name = name;
		this.password = password;
		this.subject = subject;
		this.content = content;
		this.writeDate = writeDate;
		this.hit = hit;
		this.notice = notice;
		this.ip = ip;
		this.commentCount = commentCount;
	}
	public FreeboardVO() {
		super();
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	@Override
	public String toString() {
		return "FreeboardVO [idx=" + idx + ", name=" + name + ", password=" + password + ", subject=" + subject
				+ ", content=" + content + ", writeDate=" + writeDate + ", hit=" + hit + ", notice=" + notice + ", ip="
				+ ip + ", commentCount=" + commentCount + "]";
	}
		
}
