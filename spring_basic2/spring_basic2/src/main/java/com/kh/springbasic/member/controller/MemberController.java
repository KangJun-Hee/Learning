package com.kh.springbasic.member.controller;

import java.io.Writer;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.springbasic.member.model.service.MemberService;
import com.kh.springbasic.member.model.vo.Member;


/*
 * controller 주요 개념 정리 
 * 
 * * ■ Controller 주요 개념 정리
 * 
 * 1. 핸들러 메소드의 URL 맵핑 관련 어노테이션 정리
 *  1) @RequestMapping 
 *   - 개념 : 가장 기본적인 Spring의 url mapping 어노테이션, get/post 둘 다 처리 가능함
 *   - 속성 값이 없을 때 : 값은 url을 나타내고, get/post를 둘다 처리할때 사용 
 *   - value : 맵핑할 URL을 지정하는 속성, '/'를 생략 가능, 여러개의 url을 지정할수 있음
 *   - method : get, post 중 지정하는 속성, 지정하지 않은 경우 get, post 둘다 처리
 *   - ex)
 *     @RequestMapping("home.do")
 *     @RequestMapping(value="home.do")
 *     @RequestMapping(value="home.do", method="RequestMethod.GET")
 *     @RequestMapping(value={"home.do", "index.do"}, method={RequestMethod.GET, RequestMethod.POST})
 * 
 *  2) @GetMapping
 *   - get 방식만 URL을 맵핑할때 사용됨
 *    @GetMapping("getHome.do")
 * 
 *  3) @PostMapping
 *    - post 방식만 URL을 맵핑할때 사용됨
 *     @PostMapping("/postHome.do")
 * 
 * 
 * 2. 핸들러 메소드 주요 파라메터(매개 변수, Parameter, 인자) 정리
 *  - 사용자가 선택적으로 핸들러 메소드의 파라메터를 정의하면 Spring은 그에 따라 자동으로 파라메터의 값을 주입(injection)
 * 
 *   1) HttpServletRequest : 사용자의 요청, 서블릿의 request와 동일
 *   2) HttpServletResponse : 사용자에게 응답할 객체, 서블릿의 response와 동일
 *   3) HttpSession : 스프링 전용, 사용자의 브라우저 연결 시점부터 종료시점까지 데이터를 서버에 보관할수 있는 영역 ★★★★★
 *   4) java.util.Locale : 지역 설정(국가, 언어 코드)  
 *   5) OutputStream, InputStream : 파일(json, 바이너리 파일) 전달이나 받을 때 사용 
 *   6) Reader, Writer : 문자열을 받을 때 사용
 *   7) Model : Jsp에 데이터를 넘길때 사용하는데, Request 보다 편리함 = Request 대용 ★★★★★
 *   8) ModelAndView : 데이터 공유 및 View에 대한 정보도 저장하는 객체 ★★★★★
 *   9) Map(컬랙션) ★★★★★
 *    : 파라메터를 자동으로 컬랙션의 Map으로 맵핑시켜서 자동으로 받아옴
 *   10) 커맨드 객체(Command Object) ★★★★★
 *    : Class/객체 단위(VO or POJO)로 파라메터를 지정하면 멤버 변수에 따라 자동으로 맵핑 시켜주는 기능
 *      반드시 getter/setter가 카멜 표기법 네이밍 룰에 따라야함 (자동완성 하거나 lombok 사용 권장)  
 *   11) 일반 파라메터 ★★★★★
 *    : @RequestParam을 통해 html-form의 name 값을 통해 java 변수로 변환하는 방법
 * 
 * 3. 핸들러 메소드 파라메터 관련 어노테이션 정리 
 *  ■ 일반 Web 관련 어노테이션
 *  - @RequestParam(value="parameter이름", 옵션.....) (어노테이션)String id, : form-name과 메소드의 인자명 맵핑 시킬수 있음
 *  - @RequestHeader(value="해더key값") (어노테이션)String ip, : Header의 정보를 가져오는 것
 *  - @ModelAttribute("View에서 사용할 변수명") : View로 Model 값을 넘길때 사용하는 방법
 *  - @CookieValue(value="쿠키key값") (어노테이션)String cookie : Client의 쿠키정보를 가져옴

 *  ■ REST 전용 어노테이션 (향후 실습)
 *  - @PathVariable("값") : restful방식으로 구현할때 URL에 있는 데이터를 가져올때 사용
 *  - @ResponseBody : 클라이언트에게 응답할때 메소드 리턴값을 JSON 형태로 반환해주는 어노테이션
 * * 
 */

// servlet 대체하는 어노테이션
@Controller
public class MemberController {

	// spring에서 생성한 bean 객체와 연결이 된다. 
	@Autowired
	private MemberService service; 
	
	
	// method 를 정의하지 않은 경우 get/post둘다 처리 가능 
	@RequestMapping("/member/index.do")
	public String index() {
		return "member/index";
		// -> viewResolver로 jsp파일과 연결됨 
	}
	
	// ---------------핸들러 메서드 스타일 정리--------------------------------
	// 1. 서블릿 스타일
	//  장점: 서블릿 하던 사람이나, 서블릿 프로젝트의 호환성을 유지할 수 있다.
	//  단점: 안쓴다.
	
	public String memberServlet(HttpServletRequest req
								 ,HttpServletResponse resp
								 ,HttpSession session) {
		
		// 회원가입시 member 내용을 객체생성해서 저장하는 내용
		Member member = new Member();
		member.setId(req.getParameter("id"));
		member.setName(req.getParameter("name"));
		member.setGender(req.getParameter("gender"));
		member.setAge(Integer.parseInt(req.getParameter("age")));
		member.setDevLang(req.getParameterValues("devLang"));
		
		// jsp로 파라메터 보내는 방법
		req.setAttribute("member", member);
		
		// session 사용법 old문법
		req.getSession().setAttribute("id", member.getId());
		
		// Spring session 사용법
		session.setAttribute("id", member.getId());
		
		return "member/memberView";
	}
	
	// 2. @RequestParam을 통한 html  - form-method 매핑하는 방법
	// RequestParam 어노테이션으로 form-name과 핸들러 메서드의 매개변수와 매핑시키는 방법
	// 스프링에서 가장 올드한 스타일 -> 아직도 사용된다.
	// Model: request, response의 기능을 대체하기 위한 객체, 주로 파라메터 담는 용도로 수행
	// @RequestParam(value="formName") : formName을 메소드 인자명과 매핑시키는 방법
	// -> 만일 formName과 메서드 인자명이 같은 경우는 생략 가능, 다른 경우에는 반드시 있어야 한다.
	
	@RequestMapping("/member/memberParams2.do")
	public String memberParam2(Model model,
				@RequestParam(value="id") String userId,
				@RequestParam(value="name") String userName,
				@RequestParam(value="gender") String gender,
				@RequestParam(value="age") int age,
				@RequestParam(value="devLang") String[] devLang) {
		
		Member m = new Member();
		m.setId(userId);
		m.setName(userName);
		m.setAge(age);
		m.setGender(gender);
		m.setDevLang(devLang);
		
		// model을 통해서 view(jsp)로 파라미터를 넘기는 방법
		// addAttribute: key- value형태로 속성값을 저장하는 방법, request의 기능을
		// 지원하는 메서드 
		model.addAttribute("member", m);
		
		return "member/memberView";
	}
	
	// 만약 form의 이름과 메소드의 매개변수명이 같은 경우 @RequestParam 생략 가능
	//  Spring 버전업이 되면서 어노테이션이션이 생략이 가능하도록 바뀌고, 권장되는 스타일 
	@RequestMapping("/member/memberParams.do")
	public String memberParam(Model model, String id, String name, String gender, int age, String[] devLang) {
		Member m = new Member(id, name, age, gender, null, devLang);
		
		// model을 통해서 view(JSP)로 파라미터를 넘기는 방법
		// addAttribute : key-value 형태로 속성값을 저장하는 방법, request의 기능을 지원하는 메소드
		model.addAttribute("member", m);
		
		return "member/memberView";
	}
	
	// 객체(vo)를 파라메터로 활용하는 방법
	// 사용자가 지정한 vo의 멤버 변수의 명칭과 form의 name 을 일치 시켜 가져오는 방법 
	// - 반드시! 멤버변수이름과 form name 을 꼭! 일치해야된다. 자동으로 매핑이 된다.
	// 주의: vo에 기본 자료형(문자열 포함)만 지원이 가능하다. 이외에 다른 객체 자료형 있는 경우
	//  처리 되지 않는다. 
	//  실제 현업에서 가장 많이 애용하는 스타일 1
	@RequestMapping("member/memberCommand2.do")
	String memberCommand2(Model model, Member member) {
		model.addAttribute("member", member);
		System.out.println("memberCommand : " + member);
		return "member/memberView";
	}
	// Model없이 vo 파라메터를 view로 넘기는 방법 
	// @ModelAttribute("name"): view에서 model 정보를 name으로 넘기는 방법
	@RequestMapping("/member/memberCommand.do")
	String memberCommand(@ModelAttribute("member") Member member) {
		return "member/memberView";
	}
	
	// 컬렉션의 map을 활용법 
	// - form 파라메터를 map으로 가져오는 방법
	// - 실제 현업에서 가장 많이 사용되는 스타일2
	// 장점: vo상관없이 모든 파라메터를 처리 가능하다.
	// 단점: value 's'에 해당되는 배열이 잘 처리 되지 않음
	//    -> values 문제는 이런 상황을 만들지 않거나 RequestParam을 통해 특별히 처리한다.
	// - 현업에서 map을 통해서 파라메터를 받고 mybatis 부로 연결하고 table명칭까지 일치하면
	// 거의 자동화 가능!
	
	@RequestMapping("member/memberMap2.do")
	String memberMap2(Model model, @RequestParam Map<String, Object> param) {
		System.out.println("memberMap : " + param);
		model.addAttribute("member", param);
		return "member/memberView";
	}
	
	@RequestMapping("member/memberMap.do")
	String memberMap(Model model, @RequestParam Map<String, Object> param, String[] devLang) {
		System.out.println("memberMap : " + param);
		param.put("devLang", devLang);
		model.addAttribute("member", param);
		return "member/memberView";
	} 
	
	// header , cookie 정보 받아오기 
	// Writer: json 이나 문자열 형태로 만들때는 Writer를 활용한다. -> resp 있었던 객체.
	// @RequestHeader : header값 가져오는 어노테이션
	// @CookieValue : 쿠키 정보를 가져올 때 사용하는 어노테이션 
	// void 인 경우는 return 없을 때 활용 ->view가 존재하지 않는다!
	// 
	@RequestMapping("/member/memberAddInfo.do")
	public void memberAddInfo(
				Writer writer,
				@RequestHeader(value="user-agent") String userAgent,
				@RequestHeader(value="referer") String prevPage,
				@CookieValue(value="saveId", required = false) String saveId
				) {
		try {
			writer.append("<html>");
			writer.append("userAgent : " + userAgent+"<br>");
			writer.append("prevPage : " + prevPage+"<br>");
			writer.append("saveId : " + saveId+"<br>");
			writer.append("</html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Service 객체 활용, ModelAndView스타일 ,에러 처리하는 방법
	// 
	
	@RequestMapping("/member/joinMember.do")
	public ModelAndView joinMember(ModelAndView model,Member member) {
		
		//실제 저장을 하기 위해서 저장을 시키는 service가 필요하다.
		// 아직 객체가 만들어 지지 않다 그래서 에러! 
		
		
		return model;
	}
	
	
	
	
}








