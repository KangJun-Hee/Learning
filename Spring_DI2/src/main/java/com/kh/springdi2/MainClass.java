package com.kh.springdi2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	//ArrayList<String> hobbies = new ArrayList<String>();
	
	
	//xml파일에서 받아오는 내용으로 빈 객체 가져오기!
	//bean 
	AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:bmi.xml");
	MyInfo myInfo = ctx.getBean("myInfo",MyInfo.class);
	
	System.out.println(myInfo);
	myInfo.getMyinfo();
}
