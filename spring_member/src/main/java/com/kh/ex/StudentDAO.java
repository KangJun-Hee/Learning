package com.kh.ex;

import java.util.HashMap;
import java.util.Map;

public class StudentDAO {
	
	private Map<String,Student> stDB = new HashMap<String, Student>();
	
	// 추가!
	public void insert(Student st) {
		this.stDB.put(st.getId(), st);
	}
	public Student select(String id) {
		return stDB.get(id);
	}
	public Map<String,Student> getStudentDB(){
		return stDB;
	}	
}
