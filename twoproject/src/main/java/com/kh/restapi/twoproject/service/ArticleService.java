package com.kh.restapi.twoproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.restapi.twoproject.dto.ArticleForm;
import com.kh.restapi.twoproject.entity.Article;
import com.kh.restapi.twoproject.repository.ArticleRepository;

import lombok.extern.slf4j.Slf4j;

//service:DB에 접근해 결과 만드는 곳!
//			컨트롤러서 DB접근해야 하면 서비스한테 넘기고
//			넘겨준 데이터 갖고 실제 DB접근해 데이터 가져온다

@Slf4j		//DB 로그를 확인하기 위해 사용
@Service
public class ArticleService {
	//ArticleRepository interface객체의 Bean을 자동으로 주입받음
	@Autowired
	private ArticleRepository articleRepository;

	//Article 전체목록 조회 실행
	public List<Article> index(){
		log.info("ArticleService's index() method runs~~~~~~");
		return articleRepository.findAll();
	}
	
	//단건 조회 한 개
	public Article show(Long id) {
		log.info("ArticleService's show() method runs~~~~~~");
		
										    //만약데이터없으면 null넘겨라
		return articleRepository.findById(id).orElse(null);
	}
	
	//생성
	public Article create(ArticleForm dto	) {
		log.info("ArticleService's create() method runs~~~~~~");
		Article article = dto.toEntity();
		
		//id는 DB가 자동생성하므로 id가 넘어오는 데이터를 저장하지 않는다
		if(article.getId() != null) {
			return null;
		}
		
		return articleRepository.save(article);
	}
	
	// 수정
		public Article update(Long id,ArticleForm dto) {
			log.info("ArticleService의 update()메서드가 실행");
			Article article = dto.toEntity();
			Article target = articleRepository.findById(id).orElse(null);
			
			// 수정할 대상이 없거나 id가 다른 경우 
			// 잘못된 요청이다 ( 400 )
			if(target == null || id != article.getId()) {
				log.info("잘못된 요청! id: {}, article:{}",id,article.toString());
				return null;
			}
			// 수정할 title이나 수정할 content 입력 되었니?
			// 수정할 대상이 있는 필드들을 새로 저장해주기!
			// patch()메서드가 한다. 
			
			target.patch(article);
			
			return articleRepository.save(target);
			
		}

	
	//삭제
	public Article delete(Long id) {
		log.info("ArticleService's delete() method runs~~~~~~");
		Article target = articleRepository.findById(id).orElse(null);
		
		//대상이 없거나 id가 다른 경우는
		//잘못된 요청이다 400번대 에러
		if(target == null) {
			log.info("잘못된 요청이다~ {}번 글은 테이블에 존재하지 않습니다~",id);
			return null;
		}
		
		articleRepository.delete(target);
		return target;
	}
	
	
	
	
	
	
	
	
	
	
	
}
