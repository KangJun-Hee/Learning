package com.kh.springodbcTemolate;

import org.springframework.jdbc.core.JdbcTemplate;

public class Constant {

	// MvcboardDAO클래스에서 사용할 수 있도록 설정 
	// public,static 데이터베이스에 접근하는 객체는 하나만 존재(싱글톤)
	public static JdbcTemplate template;

}
