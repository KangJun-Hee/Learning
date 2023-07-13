package com.kh.springdi;

public class Info {
	String id;
	String pw;
	String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void printInfo() {
		System.out.println("[id=" + id + ", pw=" + pw + ", "
							+ "name=" + name + "]"); 
	}
	
	
}

//스프링의 의존성주입DI
//	객체간 의존성을 개발자가 객체내부에서 직접 호출하는 거(new연산자) '대신'
//	스프링컨테이너에서 객체 생성해 넣어 주는 방식~

//자바에서 사용하던 방식
//xml파일에서 설정한 bean정보를 읽어 들인다~
//class의 bean설정하는 xml파일을 만들어 저장한다~


















