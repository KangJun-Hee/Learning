package com.kh.restapi.twoproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kh.restapi.twoproject.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	//@Query어노테이션으로 query를 만들어 사용가능
	//특정 게시글의 모든 댓글 조회하는 메서드
	@Query(value = "select * from comment where article_id =: articleId"
			, nativeQuery=true)
	List<Comment> findByArticleId(Long articleId);
	
	//특정 닉넴의 모든 댓글을 조회하는 메서드
}
