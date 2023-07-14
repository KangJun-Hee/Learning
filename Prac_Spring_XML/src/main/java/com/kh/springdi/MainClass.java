package com.kh.springdi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
	// 어노테이션을 이용해서 bean을 생성했을 때 spring에서는 xml클래스로 받는 것이 아니라
	// 새로운 클래스로 저장해야된다.
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx 
			= new AnnotationConfigApplicationContext(AConfig.class);
		
		Login login = ctx.getBean("login",Login.class);
		if
		System.out.println(login.getId());
	}
}
