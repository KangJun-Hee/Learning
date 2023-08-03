package com.kh.restapi.twoproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.kh.restapi.twoproject.dto.CommentDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity//DB타입이니깐
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Slf4j
public class Comment {
	@Id //기본키
	@GeneratedValue(strategy = GenerationType.IDENTITY)//기본시퀀스를 DB가 자동증가시킴
	private Long id;
	
	@Column//얘네가 컬럼이다
	private String nickname;
	@Column
	private String body;
	
			  //jpa에 단방향
	@ManyToOne//댓글entity(Comment)여러개가 하나의 메인글(Article)에 연관된다
	@JoinColumn(name = "article_id")//article_id컬럼에 article의 대표값(기본키)을 저장함
	private Article article;
	
	//
	public static Comment createCommnet(CommentDto dto, Article article) {
		log.info("Comment's createComment() method runs");
		log.info("dto:{}",dto);
		log.info("Article:{}",article);
		
		//예외발생
		//댓글의 id는 DB가 자동으로 붙여주기에 id가 넘어오는 경우 예외를 발생시킨다
		if(dto.getId() != null) {
			throw new IllegalArgumentException("댓글생성실패~ 댓글의 id는 없어야 함!");
		}
		//댓글 생성위해 요청한 id와 DB에 저장된 id가 다를 경우 예외를 발생시킨다
		if(dto.getArticleId() != article.getId()) {
			throw new IllegalArgumentException("댓글생성실패~ 게시글의 id가 잘못됐습니다~");
		}
		
		//entity 변환
		return new Comment(dto.getId(),dto.getNickname(),dto.getBody(),article);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
