package com.kh.ex;

public class StudentInsert {
	// StudentDAO    주소값은 가지고 있어야 된다 그래야 데이터베이스 접근 가능
	private StudentDAO studentDAO;
	
	public StudentInsert(StudentDAO stDAO) {
		this.studentDAO = stDAO;
	}
	
	// 추가하기 
	public void insert(Student student) {
		String id = student.getId();
		
		if(checkId(id)) {
			System.out.println("추가가능");
			studentDAO.insert(student);
		}else {
			System.out.println("중복적인 아이디입니다.!");
		}		
	}	
	// 중복적인 아이디 확인하는 내용
	 public boolean checkId(String id) {
		 // 데이터베이스에서 중복적인 아이디 확인하기 
		 Student student = studentDAO.select(id);
		 return student == null ? true : false;
	 }
}








