package com.kh.springjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired//커넥션객체정보담고잇음
	DataSource dataSource;
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
	
		try {
			conn = dataSource.getConnection();
			
			// 내이름 5등 5등입니다 0 0 
			String sql = "select count(*) from MVCBOARD";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getInt(1));
			}
			
			if(conn!=null) {
				System.out.println("연결성공!");
			}
		} catch (Exception e) {
			System.out.println("연결에러!");
		}
		
		return "home";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
