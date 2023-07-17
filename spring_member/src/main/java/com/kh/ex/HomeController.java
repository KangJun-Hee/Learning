package com.kh.ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	// xml파일에 있는 객체를 이용해서 자동으로 매칭 시켜준다. 
	@Autowired
	StudentController controller;
		
	@RequestMapping("/")
	public String home() {
		
		String [] id = {"test" , "koreait" , "stst" , "jsp" };
		String[] name = {"이만수" , "김철수" ,"이영희" , "유재석"};
		int [] num = {1001, 1002, 1003 , 1004};
		
		StudentInsert stInsert = controller.getInsert();
		
		// 반복문이용해서 st객체를 저장 
		for(int i = 0; i < id.length; i++) {
			Student st = new Student(num[i],id[i],name[i]);
			stInsert.insert(st);
		}
		
		StudentSelect stSelect = controller.getSelect();
		
		
		StudentSelectAll stSelectAll = controller.getSelectAll();
		stSelectAll.printAll();
		
		return "home";
	}
	
}

//	
//	
//	@RequestMapping("/add3")
//	public String add3(Model model,Data data) {
//		
//		int result = data.getN1() + data.getN2();
//		
//		model.addAttribute("result",result);
//		
//		return "add";
//	}	
//	
//	@RequestMapping("/add2")
//	public String add2(Model model,int n1,int n2) {
//		
//		int result = n1 + n2;
//		
//		model.addAttribute("result",result);
//		
//		return "add";
//	}
//	
//		
//	@RequestMapping("/add1")
//	public String add1(HttpServletRequest req,Model model) {
//		// url을 타고 변수값들이 넘어온다.
//		// 그 변수값들을 꺼내서 더한다음에 뷰 페이지로 넘길 예정!
//		int n1 = Integer.parseInt(req.getParameter("n1"));
//		int n2 = Integer.parseInt(req.getParameter("n2"));
//		
//		System.out.println("n1: " + n1);
//		System.out.println("n2: " + n2);		
//		
//		int result = n1 + n2;
//		
//		model.addAttribute("result",result);
//		
//		return "add";
//	}
//	