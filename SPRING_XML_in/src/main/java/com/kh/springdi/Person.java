package com.kh.springdi;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Person implements InitializingBean, DisposableBean{
	private String name;
	private int age;
	
	public Person() {
		System.out.println("기본 생성자!");
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}


	//1.인터페이스로 구현
	//2.설정정보에 초기화메서드,종료메서드 지정
	//3.어노테이션으로 지정
	
	//afterPropertiesSet()메서드엔 bean이 생성(생성자가 실행)된 후
	//자동으로 실행할 내용 구현함~
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("aferPropertiesSet()메서드 실행~");
	}

	//DisposableBean인터페이스 구현받으면 destroy()메서드를
	//반드시 오버라이딩해서 사용해야 함
	//destroy()메서드는 bean이 소멸시(DI컨테이너에서 close()메서드 실행시)
	//자동으로 실행할 내용 구현한다
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy()메서드를 실행~~");
	}
	
	//스프링전용 인터페이스라 이름을 변경하는 건 불가능
	//초기화하는 메서드, 소멸메서드
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
