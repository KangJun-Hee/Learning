package com.kh.firstproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.firstproject.entity.Article;
import com.kh.firstproject.dto.ArticleForm;
import com.kh.firstproject.repository.ArticleRepository;

@Controller
public class ArticleController {
	//JPA Repository인터페이스의 객체 선언하고 @Autowired로 초기화한다
	//spring boot가 미리 생성해 놓은 객체를 가져와 자동연결함
	@Autowired
	private ArticleRepository articleRepository;
	
	//뷰페이지만들기
	@GetMapping("/Articles/new")//라고 치면
	public String newArticleForm() {
		return "Articles/new";//로 넘어감
	}
	
	//form에서 넘어오는 데이터는 매핑 PostMapping()
	@PostMapping("/Articles/create")
	public String createArticle(ArticleForm form) {
		System.out.println(form);
		
		//DTO의 데이터를 Entity로 변환한다
		Article article = form.toEntity();
		System.out.println(article);
		
		//Repository에게 entity를 DB에 저장하게 한다
		//id는 자동으로 증가된다
		Article saved = articleRepository.save(article);
		System.out.println(saved);
		
		return "Articles/new";
	}
	
	@GetMapping("/articles/new")
	public String newArticleForm2() {
		
		//lombok테스트용
		ArticleForm a1 = new ArticleForm("dldl", "ddd");
		System.out.println("test:"+a1);
		
		return "articles/new";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
