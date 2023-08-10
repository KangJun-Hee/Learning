package com.kh.mybatis;


import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.mybatis.member.Member;

/**
 * DI(Dependency Injection)의존성주입
 *  - 등장배경:서블릿처럼 복잡한상속으로 설계된코드=결합도가 높다=코드유지보수 어렵=수정시 연결된 다른코드도 다 바꿔야 함
 *  
 *  ->결합도 낮추기 위해 IOC개념 활용:직접적 상속은 배제(new사용), 간접적으로 interface사용(@또는 xml)
 *  ->직접객체생성 안함,프레임워크서 사용자가 만든 객체를 생성해 프로그램에 주입
 *  ->의존성을 최대한 낮추는 방향으로 설계됨
 *  
 *  ->장점:느슨한 결합구조=코드간결,유지보수성 증가,상속에 의한 복잡성 감소
 *  ->단점:DI사용 위해 java외의 @ 표기와 xml코드의 코드부가 증가가능(스프링에선 어쩔 수 없)
 *  	->단점보안:xml걷어내려고 spring boot!
 *  
 *  DI활용 위해 MVC주요레이어에 붙는 어노테이션
 *  @Controller:url처리 가능한 컨트롤러에 붙음
 *  @Service:비즈니스 로직처리 위해 서비스 계층에 붙음
 *  @Repository:DB나 Data처리 가능한 계층에 붙음(주로 DAO)
 *  @Component:계층이 아닌 일반객체 생성시 사용함
 *  
 *  DI통한 객체생성시 활용 어노테이션
 *  @Autowired:객체생성시 사용(new 대신)
 *  @Value:단순 값을 주입할 때 사용
 *  @Resource:자원 연결시 사용, 주로 프로퍼티에
 *  
 */
@Controller
public class HomeController {
	
	//DI(Bean)객체 생성법
	//1. Bean이 단일 id로 선언된 경우:@Autowired만 연결하면 됨 new문법 없이!
	//@Autowired
	//Member member;
	//@Autowired
	//Member member2;
	
	//2.bean이 다중id로 여러개 선언된 경우
	//UnsatistiedDependencyException
	//NoUniqueBeanDefinitionException
	//@Qualifier("id값"):Bean에 구분자를 같이 삽입해 사용할 의존객체 선택가능!
	//@Qualifier("id값")의 id는 java변수명과 일치하지 않아도 된다~
		//bean을 못 찾을 경우 필드나 파라미터이름으로 매칭시도
		//그래도 찾지 못하면 NoSuchBeanDefinitionException이 뜸
	@Autowired
	@Qualifier("testMember")
	Member member;
	@Autowired	
	@Qualifier("testMember2")
	Member member2;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("member",member);
		model.addAttribute("member2",member2);
		
		return "home";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
