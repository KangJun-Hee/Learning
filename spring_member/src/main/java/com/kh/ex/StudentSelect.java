package com.kh.ex;

public class StudentSelect {

	// DAO
	// 생성자 이용해서 DAO받고
	private StudentDAO studentDAO;

	public StudentSelect(StudentDAO stDAO) {
		this.studentDAO = stDAO;
	}

	
	public Student select(String id) {
		
		if (checkId(id)) {
			return studentDAO.select(id);
		} else {
			System.out.println("정보가 없습니다.!.!");
		}
		return null;
	}
	public boolean checkId(String id) {
		
		Student student = studentDAO.select(id);
		return student != null ? true : false;
	}
}
