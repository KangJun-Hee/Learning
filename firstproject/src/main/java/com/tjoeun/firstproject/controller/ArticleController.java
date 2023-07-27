package com.tjoeun.firstproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tjoeun.firstproject.dto.ArticleForm;
import com.tjoeun.firstproject.entity.Article;
import com.tjoeun.firstproject.repository.ArticleRepository;

@Controller
public class ArticleController {

//	JPA Repository 인터페이스 객체를 선언하고 @Autowired로 초기화 한다.
	@Autowired // SpringBoot가 미리 생성해놓은 객체를 가져다 자동으로 연결한다.
	private ArticleRepository articleRepository;
	
	@GetMapping("/Articles/new")
	public String newArticleForm() {
		
		return "Articles/new";//로 넘어감
	}
	
	@PostMapping("/Articles/create")
//	form에서 넘어오는 데이터는 커맨드 객체에 저장된다.
	public String createArticle(ArticleForm form) {
		System.out.println(form);

//		DTO의 데이터를 Entity로 변환한다.
		Article article = form.toEntity();
		System.out.println(article);
//		Repository에게 Entity를 데이터베이스에 저장하게 한다.
//		id가 자동으로 증가된다.
		Article saved = articleRepository.save(article);
		System.out.println(saved);

		// 1건이 저장이 완료되었으면 redirect를 이용해서 목록 보기나 작성한 글 보기로 
		// 넘겨준다. 
		return "redirect:/Articles"; //목록보기 
		// return "redirect:/Articles/" +saved.getId() //작성한 글 보기 
	}
	
	// 브라우저에서 /articles/글번호 형태의 요청을 받아서 처리한다.
	// {} /articles/1,/articles/2, 
	// {변수명}를 통해서 받는 데이터를 저장할 변수를 만들고 
	// url의 들어오는 값을 변수명으로 매칭시켜서 사용할 수있도록 어노테이션을
	// 사용한다. 
	@GetMapping("/Articles/{id}")
	public String show(@PathVariable Long id,Model model) {
		System.out.println("컨트롤러의 show() 메서드 실행");
		System.out.println("id ="+ id);
		
			
		Article articleEcntity = articleRepository.findById(id).orElse(null);
		
		// 테이블에서 데이터를 가져와서 show.mustache 파일로 넘기기 위해서 model 인터페이스객체
		// 에 넣어준다. 
		
		model.addAttribute("article",articleEcntity);
		// 뷰 페이지로 이동한다.
		
		return "Articles/show"; 
	}
	
	// 전체 글 보기!
		@GetMapping("/Articles")
		public String index(Model model) {
			System.out.println("컨트롤러의 index() 메서드 실행");

			// 테이블에 저장된 모든 글 목록을 얻어온다.
			// jdk 8버전 findAll() 반환하는 값이 다를 수 있기 때문에
			// 만약 util 자바패키지를 포함했는데도 에러가나면 필히 findAll() 메서드
			// 반환값을 확인하세요~
			List<Article> articleEntityList = articleRepository.findAll();
			System.out.println(articleEntityList);

			// 가져온 글의 목록을 idex.mustache로 넘겨주기 위해서 model 객체에 저장한다.
			model.addAttribute("articleList", articleEntityList);

			return "Articles/index"; // 뷰페이지 파일명
		}
	
	//글번호 가지고 수정하는 메서드
		@GetMapping("/Articles/{id}/edit")
		public String edit(@PathVariable Long id, Model model) {
			System.out.println("컨트롤러의 edit() 메서드를 실행");
			System.out.println("id = " + id);

			// 수정할 데이터를 얻어온다.
			Article articleEcntity = articleRepository.findById(id).orElse(null);

			// 테이블에서 데이터를 가져와서 show.mustache 파일로 넘기기 위해서 model 인터페이스객체
			// 에 넣어준다.
			System.out.println("1");
			model.addAttribute("article", articleEcntity);
			// 뷰 페이지로 이동한다.
			System.out.println("df");
			return "Articles/edit";
		}
	
	//form에서 넘어오는 데이터전체를 받기위해 커맨드 객체를 사용한다
	@PostMapping("/Articles/update")
	public String update(ArticleForm form) {
		System.out.println("controller's update() method runs~");
		System.out.println(form.toString());
		
		//DTO->Entity로 변환한다
		Article article = form.toEntity();
		System.out.println(article.toString());
		
		//DB에 저장된 수정할데이터 얻어와 Entity로 수정후 DB에 저장한다
		Article target = articleRepository.findById(article.getId()).orElse(null);
		
		if(target != null) {
			articleRepository.save(article);
		}

		//수정한 글 1건만 보여 주고 싶을 때
		return "redirect:/Articles/"+article.getId();
   //전체목록보기  "redirect:/Articles/"
	}
	
	// 글을 삭제하기 
	@GetMapping("/Articles/{id}/delete")
	public String delete(@PathVariable Long id,RedirectAttributes rttr) {
		
		System.out.println("컨트롤러 delete() 메서드를 실행");
		System.out.println("id : " + id);
		
		// 삭제할 데이터를 가져온다. 
		Article target = articleRepository.findById(id).orElse(null);
		System.out.println(target.toString());
		
		// 데이터 삭제!
		if(target != null) {
			articleRepository.delete(target);				
			// 메서드를 이용해서 1회성으로 1번만 사용할 메시지를 뷰 페이지로 전달 한다.
			rttr.addFlashAttribute("msg",id +"번 글 삭제 완료!");
			System.out.println(id+"번 글 삭제완료~");
		}			
		return "redirect:/Articles";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}