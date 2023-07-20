package com.kh.springodbcTemolate.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;

import com.kh.springodbcTemolate.dao.MvcboardDAO;
import com.kh.springodbcTemolate.vo.MvcboardList;
import com.kh.springodbcTemolate.vo.MvcboardVO;

public class SelectService implements MvcboardService {
	private static final Logger logger = LoggerFactory.getLogger(InsertSerive.class);

	@Override
	public void execute(MvcboardVO mvcboardvo) {
	}

	@Override
	public void execute(Model model) {
		Logger.info("execute() select - model사용!");

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");

		//MvcboardVO mvcboardVO = ctx.getBean("select", SelectService.class);

		MvcboardDAO mvcboardDAO = ctx.getBean("mvcboardDAO", MvcboardDAO.class);
		int pageSize = 10;
		int currentPage = 1;
		
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} catch (NumberFormatException e) {
			//list페이지 구현위해 가장 첫 번째 전체게시글 수
			int totalCount = mvcboardDAO.selectCount();
			logger.info("테이블에 저장된 전체글 개수:{}",totalCount);
			
			//현재 테이블은 기본4개 저장돼있다 만약 아무글도없다면 예외발생가능성있음
			//처리하는 내용 추가
			MvcboardList mvcboardList = ctx.getBean("mvcboardList",MvcboardList.class);
			
			logger.info("{}",mvcboardList);
			
			//게시글보여줄때 가장 중요한 시작행,끝행
			HashMap<String, Integer> hmap = new HashMap<String, Integer>();
			hmap.put("startNo",mvcboardList.getStartNo());
			hmap.put("endNo",mvcboardList.getEndNo());
			
			mvcboardList.setList(mvcboardDAO.selectList(hmap));
			logger.info("{}",mvcboardList.getList());
			
			//list.jsp로 넘겨줄 데이터를 model인터페이스객체에 넣어준다

		}

	}

}
