package com.kh.springodbcTemolate.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;

import com.kh.springodbcTemolate.dao.MvcboardDAO;
import com.kh.springodbcTemolate.vo.MvcboardVO;

public class InsertSerive implements MvcboardService{
	private static final Logger logger = LoggerFactory.getLogger(InsertSerive.class);

	@Override
	public void execute(MvcboardVO mvcboardvo) {
		
	}

	@Override
	public void execute(Model model) {
		Logger.info("execute() - model사용!");
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		//xml설정파일에서 빈 가지고 오기!
		AbstractApplicationContext ctx 
					= new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		MvcboardVO mvcboardVO = ctx.getBean("mvcboardVO",MvcboardVO.class);
		mvcboardVO.setName(name);
		mvcboardVO.setSubject(subject);
		mvcboardVO.setContent(content);
		
		MvcboardDAO mvcboardDAO = ctx.getBean("mvcboardDAO",MvcboardDAO.class);
		mvcboardDAO.insert(mvcboardVO);//DAO안에서 insert문 실행됨
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
