package com.kh.restapi.twoproject.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.restapi.twoproject.dto.ArticleForm;
import com.kh.restapi.twoproject.entity.Article;
import com.kh.restapi.twoproject.service.ArticleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController // RestAPI용 컨트롤러:데이터를 json형식으로 반환
public class ArticleApiController {

	// ArticleService interface 객체를 bean 자동주입받는다
	@Autowired
	private ArticleService articleService;

	// get 글 전체조회 articles가 가짐
	@GetMapping("/api/articles")
	public List<Article> index() {
		log.info("ArticleApiController's index() method runs~~~~~~");

		// service's index()호출해 DB처리결과 받음
		return articleService.index();
	}

	// 하나의 글 조회시 사용
	@GetMapping("/api/articles/{id}")
	public Article show(@PathVariable Long id) {
		log.info("ArticleApiController's show() method runs~~~~~~");

		return articleService.show(id);
	}

	// post
	// form서 데이터 받을시 커맨드객체로 받으면 되지만
	// REST API서 JSON으로 던지는 데이터 받을시
	// body부분에 담겨오는 데이터 받아야 하므로 커맨드 객체에
	// @RequestBody를 붙여 받아야 함
	// 데이터를 테이블에 저장하고 데이터 리턴시킴
	// 상태코드,데이터 2개 받아야 되기에 응답받을시
	// ResponseEntity객체 사용해야 함
	@PostMapping("/api/articles")
	public ResponseEntity<Article> create(@RequestBody ArticleForm dto) {
		log.info("ArticleApiController's create() method runs~~~~~~");
		log.info(dto.toString());

		Article saved = articleService.create(dto);

		// 혹시 에러발생 가능한 것도 처리해야 함
		// body가 비어있을 경우 build()이용해 body부분 없이 넘긴다!
		return saved != null ? ResponseEntity.status(HttpStatus.CREATED).body(saved)
				: ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	// patch
	// 수정요청
	@PatchMapping("/api/articles/{id}")
	public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {
		log.info("ArticleApiController의 update()메서드가 실행");
		log.info("id :" + id);
		log.info(dto.toString());

		Article article = dto.toEntity(); // 수정하기 위해 입력한 데이터

		// 수정할 엔티티를 조회한다.
//			
//			 Article target = this.articleRepository.findById(article.getId()).orElse(null);
		//
//			    if (target != null) {
//			      articleRepository.save(article);
//			    }

		Article updated = articleService.update(id, dto);

		return updated != null ? ResponseEntity.status(HttpStatus.OK).body(updated)
				: ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	// delete 글번호 이용해 삭제
	@DeleteMapping("/api/articles/{id}")
	public ResponseEntity<Article> delete(@PathVariable Long id) {

		log.info("ArticleApiController's delete() method runs");
		log.info("id:" + id);

		// 삭제한 데이터 확인해 null 아니면 정상적으로 삭제됐다고 선택해 돌려 줄 것!
		// 아님 삭제과성서 에러났나 확인
		Article deleted = articleService.delete(id);

		return deleted != null ? ResponseEntity.status(HttpStatus.OK).build()
				: ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

}
