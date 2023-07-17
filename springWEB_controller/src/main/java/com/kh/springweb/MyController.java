package com.kh.springweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);
	
	//@RequestMapping 어노테이션이 설정된 메서드는 Model 인터페이스 객체를 인수로 
	// 가질 수 있다. 
	@RequestMapping("/model")
	public String model(Model model) {
		
		// addAttribute(key,value)
		model.addAttribute("id","qwer");
		model.addAttribute("pw","1234");
		model.addAttribute("name","홍길동");		
		
		return "model/model";
	}
	
	@RequestMapping("/modelAndView")
	// ModelAndView 클래스는 뷰 페이지 이름과 뷰페이지로 넘겨줄 데이터를 저장한다.
	// 뷰 페이지 이름과 뷰페이지로 넘겨줄 데이터를 ModelAndView 클래스 객체에 저장해서 리턴시키야
	// 하므로 메서드 리턴타입에 뷰페지로 넘겨줄 데이터와 뷰 페이지 이름을 저장할 객체 선언을 해야된다.
	
	public ModelAndView modelAndView() {
		
		logger.info("modelAndView()");
		ModelAndView modelAndView = new ModelAndView();
		
		// setViewName() 메서드로 ModelAndView 클래스 객체에 뷰 페이지 이름을 넣어준다.
		modelAndView.setViewName("modelAndView/modelAndView");
		
		// addObject(key,value) 메서드로 ModelAndView 클래스 객체에 key에 따른 value를 넣어준다.
		// 뷰 페이지로 넘겨줄 데이터를 저장한다. 
		modelAndView.addObject("id", "qwer22");
		modelAndView.addObject("pw", "123456");
		modelAndView.addObject("name", "홍언니");
						
		// 객체를 리턴 시킨다. 
		return modelAndView;
	}
	
	
	
	
	
	
	
}
