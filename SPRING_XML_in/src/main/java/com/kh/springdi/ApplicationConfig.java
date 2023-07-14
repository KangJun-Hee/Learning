package com.kh.springdi;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	//@Bean(initMethod="init",destroyMethod="close")처럼
	//지정을 할 수 있다
	@Bean
	public Student student() {
		
		
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("바둑");
		hobbies.add("골프");
		hobbies.add("테스니");
		
		Student student = new Student("이서희",20,hobbies);
		student.setHeight(178);
		student.setWeight(80);
				
		return student;  //초기화된 bean 객체를 리턴한다. 
	}
	
	/*
	@PostConstruct
	public void init() {}
	
	@PreDestroy
	public void close() {}
	*/
	
	
	
	// DI (Dependency Injection)
	//   - 클래스 간의 의존 관계를 스프링 컨테이너가 자동으로 연결해주는 것!
	
	// 어노테이션 @
	//  - 스프링에서 빈 인스턴스가 생성된 이후 @Autowired 설정한 메서드가 자동으로 호출되고 
	//    인스턴스가 자동으로 주입된다. 
	//  - 해당 변수가 혹은 메서드가 스프링이 관리하는 Bean을 자동으로 매핑해주는 개념이다! 
	
	// ApplicationConfig는 DI 설정에 사용되는 클래스 임을 spring에게 알려준다. 
	
	// <bean id="" class="">
	// 적당한 이름의 메서드를 만들고 @Bean 어노테이션을 붙여서 bean을 설정하는 xml파일 <bean>태그 
	// 역할을 한다는 것을 spring한다 알려준다!
	
	// @Bean
	// public 리턴타입[class 속성값=> 클래스이름만] 메서드이름[id속성값](){
	//    생성자나 setter 메서드를 이용해서 bean 초기화는 작업을 실행한다. 
	//    return bean객체; 	
	// }
	
	
	
	
}
