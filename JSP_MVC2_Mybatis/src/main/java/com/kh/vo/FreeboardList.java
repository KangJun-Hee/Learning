package com.kh.vo;

import java.util.ArrayList;

// 1페이지 분량의 메인글 목록과 페이징 작업에 사용할 8개의 변수를 기억하는 클래스 

public class FreeboardList {

	ArrayList<FreeboardVO> list = new ArrayList();
	private int pageSize = 10;
	private int totalCount = 0;
	private int totalPage = 0;
	private int currentPage = 1;
	private int startNo = 0;
	private int endNo = 0;
	private int startPage = 0;
	private int endPage = 0;
	
	
	
	public FreeboardList() {
		super();
	}
	public FreeboardList(ArrayList<FreeboardVO> list, int pageSize, int totalCount, int totalPage, int currentPage,
			int startNo, int endNo, int startPage, int endPage) {
		super();
		this.list = list;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.startNo = startNo;
		this.endNo = endNo;
		this.startPage = startPage;
		this.endPage = endPage;
	}
	
	
	public ArrayList<FreeboardVO> getList() {
		return list;
	}
	public void setList(ArrayList<FreeboardVO> list) {
		this.list = list;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartNo() {
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public int getEndNo() {
		return endNo;
	}
	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	@Override
	public String toString() {
		return "FreeboardList [list=" + list + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + ", currentPage=" + currentPage + ", startNo=" + startNo + ", endNo=" + endNo
				+ ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
		
}
