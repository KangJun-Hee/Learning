package com.kh.springodbcTemolate.service;

import org.springframework.ui.Model;
import com.kh.springodbcTemolate.vo.MvcboardVO;

public interface MvcboardSerive {

		public abstract void execute(MvcboardVO mvcboardvo);
		public abstract void execute(Model model);
	
	
}
