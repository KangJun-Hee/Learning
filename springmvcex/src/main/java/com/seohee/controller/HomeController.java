package com.seohee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	//어떤 서블릿=컨트롤러로 이동할지
	//request요청을 하면 url:"" method=get/post/put/...
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("hello요청");
		
		//결과가 나오면 실행할 페이지명을 넘긴다
		//실제 제이터가 넘어가 수도 있다
		return "hello";
	}
	@RequestMapping("/hello2")
	public void hello2() {
		System.out.println("hello요청2");
	}
	@RequestMapping("/hello3")
	public void hello3() {
		System.out.println("hello요청3");
	}
	//url요청 받아 구별했으면 실제 서블릿들의 객체를 생성해 실행
	//web-inf -> spring -> root-context.xml파일이 실행을 재준다
							//이안에설정해야함. 객체실행하는 Bean
	
	//위의 내용까지만 설정하면 404오류뜬다
	//보여지는 뷰페이지 없기에 에러남~
	//뷰가 가진 jsp파일명 넘겨 줘야 함
	
	//만약 서블릿을 실행 후 결과값 저장하는 내용 써야할 때
	@RequestMapping("/hello5")
	public String hello5(Model model) {
		//실제 데이터의 결과값들이 model에서 넘어오면
		//model이란 객체 만들어 실제저장
		//얘는 request.setAttr()저장을 해 뷰로 포워드시킴~
		//현재 페이지서 저장한 내용을 다음페이지까진 데이터가 유지됨
		model.addAttribute("name","홍길동");
		
		//페이지명
		return "hello5";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
