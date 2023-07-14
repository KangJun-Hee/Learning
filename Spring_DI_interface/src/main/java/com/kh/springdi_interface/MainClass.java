package com.kh.springdi_interface;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//스프링컨테이너 종류
		//Bean Factory
		//	- 스프링설정파일에 등록된 bean객체 생성하고 관리하는 기본적 기능만 함~
		//	- 클라이언트 요청에 의해 Bean객체가 사용되는 시점에 객체를 생성하는 방식
		
		//ApplicationContext 2가지(Bean Factory상속받음)
		//	- Bean Factory와 똑같은 기능
		//	- 메세지기반 다국어 처리,aop처리,트랜잭션관리
		//	  컨테이너가 구동되는 시점에 객체들이 생성이 되는 방식
		
		
		//GenericXmlApplicationContext
		//	파일시스템이나 클라스경로에 있는 xml파일을 로딩해 구동하는 컨테이너
		
		//mvc구조를 대부분 XmlApplicationContext
		//	웹기반 스프링 어플리케이션 개발시 사용하는 컨테이너
		
		AbstractApplicationContext ctx = 
						new GenericXmlApplicationContext("classpath:pencilctx.xml");
		
		Pencil pencil = ctx.getBean("Pencil4B",Pencil4B.class);
		pencil.use();
		
		pencil = ctx.getBean("PencilH4B",PencilH4B.class);
		pencil.use();
		
		pencil = ctx.getBean("PencilHB",PencilHB.class);
		pencil.use();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}