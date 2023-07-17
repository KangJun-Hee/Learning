package com.kh.springProperties;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {
	public static void main(String[] args) {
		
		// ConfigurableApplicationContext 인터페이스 타입으로 환경 설정 정보를 
		// 읽어올 객체(컨테이너)를 만든다. 
		
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		
		ConfigurableEnvironment env = ctx.getEnvironment();
		
		// properties 정보를 저장하는 MutablePropertySource 클래스 객체에 
		// ConfigurableEnvironment 인터페이스 타입의 객체에서 getPropertySources()
		// 메서드를 이용해서 정보만 얻어온다. 
		
		MutablePropertySources mps = env.getPropertySources();
		
		// addLast() 맨 마지막 위치에 admin.properties 파일의 내용을 읽어서 추가한다.
		try {
			mps.addLast(new ResourcePropertySource("classpath:admin.properties"));
		
			System.out.println("admin.id:" + env.getProperty("admin.id"));
			System.out.println("admin.id:" + env.getProperty("admin.pw"));
			System.out.println("properties파일의 내용을 읽어 스프링 컨테이너에 저장한 후 얻어온다.");
			
		} catch (IOException e) {
			
			System.out.println("admin.properties파일을 읽어올 수 없습니다.");
		}
		
		System.out.println("===============================================");
		
		// adminConnection클래스의 bean 을 얻어온다.
		// 실제 빈에서 데이터를 꺼내올 때 사용하는 방법을 이용해서 
		// 데이터를 출력해 보세요~ 
		
		AbstractApplicationContext gCtx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);
		System.out.println("admin.id: " + adminConnection.getAdminId()); // null
		System.out.println("admin.pw: " + adminConnection.getAdminPw()); // null
		System.out.println("===================================================================");
		
//		AdminConnection 클래스의 bean이 생성된 후 환경 설정 정보에 저장된 admin.properties 파일의
//		정보를 넘겨준다.
		System.out.println("AdminConnection 클래스의 bean이 생성된 후 properties 파일의 정보를 넣어준다.");
		adminConnection.setAdminId(env.getProperty("admin.id"));
		adminConnection.setAdminPw(env.getProperty("admin.pw"));
		System.out.println("admin.id: " + adminConnection.getAdminId()); //
		System.out.println("admin.pw: " + adminConnection.getAdminPw()); // 
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
