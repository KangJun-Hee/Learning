package com.kh.restapi.twoproject.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.restapi.twoproject.dto.ArticleForm;
import com.kh.restapi.twoproject.entity.Article;

//인텔리j는 테스트하고픈 메서드 우클릭->제너레이트->테스트

@SpringBootTest//어노테이션 붙여 스프링부트와 연동한 통합테스트를 수행함~
class ArticleServiceTest {
	
	@Autowired //ArticleService를 DI
	ArticleService articleService;

	@Test
	void testIndex() {
//		Article a = new Article(1L,"한꼬미","천재");
//		Article b = new Article(1L,"두꼬미","처언재");
//		Article c = new Article(1L,"세꼬미","처어언재");
		
		//예상:모든 게시물 불러오면 data.sql에 저장했던 데이터들이 불러와질 것이라는 
		Article article1 = new Article(1L, "홍길동", "천재");
		Article article2 = new Article(2L, "임꺽정", "처언재");
		Article article3 = new Article(3L, "장길산", "처어언재");
		Article article4 = new Article(4L, "일지매", "처어어언재");
		

		
		// List만들기 
		List<Article> expected = new ArrayList<Article>(Arrays
				.asList(article1,article2,article3,article4));
		
		//실제:DB서 데이터를 가져오는 서비스 이용해 데이터 저장,
		//		실제내용과 위에 들어가는 내용 비교하는 메서드로 asserEquals()
		List<Article> articles = articleService.index();
		
		//비교
		assertEquals(expected.toString(),articles.toString());
	}
	
	@Test
	void testShow_성공_존재하는_id() {
		//예상
		Long id = 1L;
		Article expected = new Article(id,"홍길동","천재");
		//실제
		Article article = articleService.show(id);
		
		//비교
		assertEquals(expected.toString(),article.toString());
	}
	
	@Test
	void testShow_실패_존재하지_않는_id() {
		//예상
		Long id = -1L;
		Article expected = null;
		//실제
		Article article = articleService.show(id);
		
		//비교
		assertEquals(expected,article);
	}
	//table이 변경되는 테스트들 실행하는 경우 이전데이터의 영향을 받아
	//하나씩 테스트할 땐 정상적으로 된다
	
	
	@Test
	@Transactional
	void testCreate_성공_title과_content만_있는_dto입력() {
		String title = "홍길동";
		String content = "수리수리마수리";
		
		ArticleForm dto = new ArticleForm(null,title,content);
		Article expected = new Article(5L,title,content);
		Article article = articleService.create(dto);
		
		assertEquals(expected.toString(), article.toString());
	}
	
	//JUnit:java를 위한 단위테스트 라이브러리
	//assert():테스트케이스의 수행결과를 판별해 알려줌
	//assertEquals(A,B):객체와 A와 B가 같은 값 가지나 확인
	//assertArrayEquals(A,B):배열 A와 B가 같은지 확인
	//assertTrue(A):조건 A가 참인지 확인
	//assertNull(A):조건 A가 널인지 확인
	

	@Test
	void testShow() {
		fail("Not yet implemented");
	}

	@Test
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}
