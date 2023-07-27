package com.tjoeun.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 이 클래스는 컨트로러로 사용되는 클래스임을 나타타낸다.
public class FirstController {

//	브라우저에 "/hi"라는 요청이 들어오면 niceToMeetYou() 메소드가 실행되게 한다.
	@GetMapping("/hi")
//	viewpage로 데이터를 넘길 때 사용할 Model 인터페이스 객체를 인수로 넣어준다.
	public String niceToMeetYou(Model model) {
//		Model 인터페이스 객체에 addAttribute() 메소드로 viewpage로 넘겨줄 데이터를 넣어준다.
		model.addAttribute("username", "홍길동");
		return "greetings"; // viewpage 이름
	}
	
	@GetMapping("/bye")
	public String seeYouNext(Model model) {
		model.addAttribute("nickname", "임꺽정");
		return "goodbye";
	}
	
}
