package com.kh.ex;

import java.util.Iterator;
import java.util.Map;

public class StudentSelectAll {
	
	private StudentDAO studentDAO;

	public StudentSelectAll(StudentDAO stDAO) {
		this.studentDAO = stDAO;
	}
	public Map<String,Student> allSelect(){
		return studentDAO.getStudentDB();
	}
	
	public void printAll() {
		Map<String,Student> map = studentDAO.getStudentDB();
		/*
		 *  for(String key : map.keySet()){
		 *  	map.get(key) 값!
		 *  }
		 * 
		 */
		
		Iterator<String> keys = map.keySet().iterator();
		
		while(keys.hasNext()) { //다음 데이터 있니? true , false
			String key = keys.next();    // 데이터 가져오기 
			map.get(key).print();			
		}	
	}
}
