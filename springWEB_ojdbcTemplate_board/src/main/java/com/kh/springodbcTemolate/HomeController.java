package com.kh.springodbcTemolate;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.springodbcTemolate.service.InsertSerive;
import com.kh.springodbcTemolate.service.MvcboardSerive;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// jdbcTemplate을  사용하려면 servlet-context.xml 파일에서 
	// 프로젝트가 실행 될때 DriverManagerDataSource 클래스의 빈 설정을 참조해서 
	// 생성한 jdbcTemplate클래스의 bean을 컨트롤러에서 
	// JdbcTemplate클래스 타입의 객체를 생성하고 넣어줘야 된다. 
	private JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}
		
	// 프로젝트가 실행하면 스프링 환경 설정파일인 servlet-context.xml
	// 파일이 읽혀진 다음 JdbcTemplate 클래스의 객체의 
	//  setter 메서드가 자동으로 실행되게 하기 위해서 
	// @Autowired 어노테이션을 붙여준다. 
	
	//  @Autowired을 붙여준 메서드는 서버가 구동되는 단계에서 자동으로 실행되며 setter의 인수
	// template으로 스프링이 알아서 servlet-context.xml 파일에서 생성한 JdbcTemplate
	// 클래스의 빈을 자동으로 전달한다. 
	// setter메서드는 자동으로 전달받은 JdbcTemplate클래스의 Bean으로 JdbcTemplate
	// 클래스 객체를 초기화 시킨다.	
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		System.out.println("캬오~~~~~~!!");
		this.template = template;
		
		// 여기까지 정상적으로 실행되면 컨트롤러에서 JdbcTemplate을 사용할 수 있게 된다.
		// 데이터베이스 연결은 주로 DAO클래스에서 하므로 컨트롤러 이외에 클래스에서 
		// JdbcTemplate을 사용할 수 있게 하기 위해서 적당한 이름의 패키지 (base-package)
		// 에 적당한 이름의 클래스를 만들고 적당한 이름으로 작성한 클래스의 정적 필드 
		// (public static JdbcTemplate template)에  
		// servlet-context.xml 파일에서 생성한 JdbcTemplate
		// 클래스의 Bean을 넣어준다. 
		
		// 적당한 이름의 클래스로 만들고 객체를 static으로 선언한 후 코딩한다.
		Constant.template = this.template;
	}
	@RequestMapping("/")
	public String start(Locale locale, Model model) {
		logger.info("start()");
		return "redirect:list";
	}
	
	@RequestMapping("/insert")
	public String insert(HttpServletRequest request, Model model) {
		logger.info("insert()");
		return "insert";
	}
	@RequestMapping("/insertOK")
	public String insertOK(HttpServletRequest request, Model model) {
		logger.info("insertOK() - model 인터페이스 객체 생성 ");
		
		model.addAttribute("request",request);
		
		
		//applicationCTX파일포함하고
		MvcboardSerive service = ctx.getBean("insert",InsertSerive.class);
		service.execute(model);
		
		
		
		return "redirect:list";
	}
	
	
}
