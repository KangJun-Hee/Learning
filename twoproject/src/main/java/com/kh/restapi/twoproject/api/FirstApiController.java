package com.kh.restapi.twoproject.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

//@Controller//뷰페이지로 연결
@RestController//실제데이터들 반환까지 가능(json). 문자도 반환
@Slf4j//lombok이 지원하는 로그레벨
public class FirstApiController {
	
	//url요청 들어오면 매핑
	@GetMapping("/api/hello")
	public String hello() {
		//lombok이 지원하는 로그레벨
		log.info("FirstApiController's hello() 메서드실행");
		
		return "hello world";
	}
	
}
/* Talend API Tester에서
 * 헤더=편지봉투   바디=봉투 속 내용물
 *
 * 헤더
	GET /posts/10000 HTTP/1.1
	Host: jsonplaceholder.typicode.com
 * 
 * 그 아래부터 바디
 */