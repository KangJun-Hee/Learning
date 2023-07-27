package com.kh.firstproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//브라우저서 /Articles/글번호   형태의 요청받아 처리한다
	//{} /Articles/1,   /Articles/2
	//{변수명}를 통해서 받는데이터를 저장할 변수를 만들고
	//url에 들어오는 값을 변수명으로 매칭시켜 사용가능하게 @PathVariable를 사용
	@GetMapping("/Articles/{id}")
	public String show(@PathVariable Long id,Model model) {
		System.out.println("controller's show() method~");
		System.out.println("id = "+id);
		
		//id 한 건마다 해당되는데이터를 테이블서 갖고 온다
		//FindById() id값을 넣어주면 테이블서 찾아 Article타입으로 결과반환
		//if data is null, or Else(null)method runs, return null!
		Article articleEntity = articleRepository.findById(id).orElse(null);
		
		//table서 데이터 갖고와 show.mustache파일로 넘기기 위해 model인터페이스 객체에 넣어준다
		model.addAttribute("article",articleEntity);
		
		//viewpage로 이동한다
		return "Articles/show";
	}
	
	
	
	
	
	
	
	
	
	
}
