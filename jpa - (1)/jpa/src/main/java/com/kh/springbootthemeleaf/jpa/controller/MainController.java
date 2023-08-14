package com.kh.springbootthemeleaf.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.springbootthemeleaf.dto.MyInfo;

@Controller
public class MainController {

	@RequestMapping("/")
	public String helloworld() {
		return "helloworld"; // helloworld.html
	}

	// 단순요청
	@RequestMapping("/thymeleaf-test")
	public String thymeleafTest() {
		return "thymeleaf-test"; // thymeleaf-test.html
	}

	// 단순요청
	@RequestMapping("/thymeleaf-test2")
	public String thymeleafTest2() {
		return "thymeleaf-test2"; // thymeleaf-test.html
	}

	// 단순요청 + 뷰페이지로 데이터(Model) 전달하기
	@RequestMapping("/thymeleaf-test3")
	public String thymeleafTest3(Model model) {

		// 뷰페이지단으로 데이터를 같이 전달
		model.addAttribute("data1", "홍길동");
		model.addAttribute("data2", "조선시대");

		return "thymeleaf-test3"; // thymeleaf-test3.html
	}

	// 단순요청 + 뷰페이지로 데이터(Model) 전달하기
	@RequestMapping("/thymeleaf-test4")
	public ModelAndView thymeleafTest4(ModelAndView mav) {

		// 뷰페이지단으로 ModelAndView를 이용해서 데이터를 전달
		// 1. 데이터를 지정
		// 2. 뷰페이지를 지정
		// 3. 리턴 
		mav.addObject("name","이순신");
		mav.addObject("age",20);
		mav.setViewName("thymeleaf-test4");
		
		return mav; // thymeleaf-test4.html
	}

	// 단순요청 + 뷰페이지로 데이터(Model) 전달하기
		@RequestMapping("/thymeleaf-test5/{num}")
		public String thymeleafTest5(@PathVariable int num,Model model) {

			// url로 num값을 넘겨서 1부터 넘겨받은 num까지 총합을 html로 출력하세요!
			// html 로 출력 될 때 num값 까지의 총합은: ** 입니다. 
			// 결과 변수
			int result = 0;
			
			// 입력된 변수 num 크기 만큼 반복하면서 합산
			// num 값은 int 외에는 받을 수 없도록 되어있기 때문에 문자열은 오류 발생.
			for( int i=1; i <= num; i++ ) {
				result += i;
			}
			
			// 뷰페이지로 결과 전달
			model.addAttribute("num", num);
			model.addAttribute("result", result);
			
			return "thymeleaf-test5";
		}
	
		//Form값 전달받기 
		// 좀 더 제대로 된 데이터를 주고 받기 위해서 Form 을 사용해서 주고 받는 것이 편리
		// 기본적으로 form 값을 주고 받을 때 get , post 방식 있다.
		
		@RequestMapping(value="/thymeleaf-test6",method=RequestMethod.GET)
		public ModelAndView formPage(ModelAndView mav) {
			
			mav.addObject("msg","아래 폼 값을 입력해주시고 전송(Send)버튼을 클릭하세요~!");
			mav.setViewName("thymeleaf-test6-form");
			
			return mav;
		}		
		@RequestMapping(value="/thymeleaf-test6",method=RequestMethod.POST)
		public ModelAndView formSend(@RequestParam("data1") String data1,				
															ModelAndView mav) {
			
			//실제 데이터는 addObject(변수명,값)
			
			mav.addObject("msg","회원님이 입력하신 값은 <span style='color:red'>" 
							+ data1 +"</span>입니다." );
			
			mav.addObject("data1",data1);
			mav.setViewName("thymeleaf-test6-form");			
			
			return mav;
		}
		
		@RequestMapping(value="/thymeleaf-test7",method=RequestMethod.GET)
		public ModelAndView multiFormPageDTO(@ModelAttribute MyInfo myinfo,				
															ModelAndView mav) {
			
				
			mav.addObject("msg","아래 여러개의 폼값을 입력하고 전송버튼을 누르시오!!");
			
			mav.addObject("formData",myinfo);
			mav.setViewName("thymeleaf-test7-form");			
			
			return mav;
		}
		
		@RequestMapping(value="/thymeleaf-test7",method=RequestMethod.POST)
		public ModelAndView multiFormSendDTO(@ModelAttribute MyInfo myinfo,				
															ModelAndView mav) {
							
			mav.addObject("formData",myinfo);
			mav.setViewName("thymeleaf-test7-form");			
			
			return mav;
		}
		
		
	
}
