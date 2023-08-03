package com.kh.restapi.twoproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

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
	
	//트랜잭션(Transaction)
	// - DB의 상태를 변화시키는 하나의 논리적기능 수행키 위한 작업단위
	// - 사용자가 시스템에 대한 서비스 요구시 시스템이 응답하기 위한 상태변환과정의 작업단위
	// - 여러 sql문들을 단일작업으로 묶어서 나눠질 수 없게 만드는 것이 트랜잭션
	// - rollback:만약 실행중에 실패하면 내용을 전부 날리고 처음으로 돌아간다
	// 예:계좌이체
	// - 끝나면 commit or rollback을 해야 한다
	
  //@Transactional 어노테이션을 이용해 메서드를 묶는다
  //데이터 추가시 문제 발생하면 추가한 내용 가지고 게시판에
  //전체출력시 문제 발생하면 실행내용 모두 취소하고
  //기존의 내용으로 돌아간다
  
  //정상적으로 실행하면 데이터를 영구적으로 저장까지 할 수 있도록 
  //만들어 주는 게 트랜잭션 처리법~
	@Transactional
	public List<Article> createArticles(List<ArticleForm> dtos){
		
		log.info("ArticleService의 createArticles메서드 실행");
		
		//stream()
		//java 8부터 추가된 자바스트림
		//추가된 컬렉션의 저장요소를 하나씩 참조해 람다식으로
		//처리를 할 수 있도록 해주는 반복자
		//데이터소스를 변경하지 않는다(읽기모드)
		//일회성스트림도 요소를 모두 읽고나면 닫혀서 사용불가
		//필요시 새 스트림 생성해 사용
		//내부적으로 반복처리함
		
		//람다식(코드를 간결히 사용()
		//간단히 람다구조로 작성한다면,이렇게 작성
		List<Article> articleList = dtos.stream()
				.map(dto -> dto.toEntity())
				.collect(Collectors.toList());
		
		log.info("articlesList:{}",articleList);
		
		articleList.stream().
			forEach(article->articleRepository.save(article));
		//강제 예외발생가능!
		//DB처리과정서 예외발생시 orElseThrow()메서드를 이용해 예외처리
		articleRepository.findById(-1L).orElseThrow(
					()-> new IllegalArgumentException("exception~~~처리~~메시지")
				);
		
		
		
		/*
		 * 아이디 이용해 데이터저장
		 * 전체적 글의 내용저장
		 * 
		//dto묶음을 entity 묶음으로 변환하는 작업
		List<Article> articleList = new ArrayList<>();
		for(int i = 0; i<dtos.size(); i++) {
			Article entity = dtos.get(i).toEntity();
			articleList.add(entity);
		}
		//entity 묶음을 DB로 저장한다
		for(int i = 0; i<articleList.size(); i++) {
			articleRepository.save(articleList.get(i));
		}
		*/
		return articleList;
	}
}

/*Test
 * 프로그램의 품질검증을 위한 것!
 * 우리 의도대로 프로그램이 동작하나 확인하는 것~
 * 
 * TDD(Test Driven Development)
 * 소프트웨어 개발시 먼저 테스트 작성한 후 코드를 작성하는 걸 강조
 * 코드작성 전 먼저 테스트해 코드작성하면 코드의 품질,안정성 높일 수 있다~
 * 
 * Junit
 * 
 * 
 * 
 * */



















