package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


//view Templates : 화면담당기술
// 웹페이지를 하나의 틀로 만들고 여기에 변수삽입하게 함
// 틀되는 페이지가 변수값에 따라 수많은 페이지로 바뀔 수 있다
// 그 도구중 하나가 Mustache

@Controller
public class OneController {

	//브라우저에서 /hi라고 요청오면 메소드 실행
	@GetMapping("/hi")
	public String oneTest(Model model) {//viewpage로 데이터 넘길시 사용할 model인터페이스객체
		
		//model인터페이스 객체에 addAttribute()메서드로
		//viewpage로 넘겨줄 데이터 넣어 보내준다
		model.addAttribute("hi","안녕");
		System.out.println(model);
		return "one";//viewpage이름
	}
	
	
}
