package com.tjoeun.vo;

import java.util.ArrayList;

//	카테고리 목록을 기억하는 클래스
public class CategoryList {

	private ArrayList<CategoryVO> list = new ArrayList<>();

	public ArrayList<CategoryVO> getList() {
		return list;
	}
	public void setList(ArrayList<CategoryVO> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		return "CategoryList [list=" + list + "]";
	}
	
}
