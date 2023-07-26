package com.kh.firstproject.dto;

import com.kh.firstproject.entity.Article;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//lombok
//setget자동으로 생성해 주는 어노테이션
//코드를 생산성있게 짧게 작성할 수 있다


@Setter@Getter@ToString

@AllArgsConstructor//@AllArgsConstructor:모든변수 사용하는 생성자
@EqualsAndHashCode//equals()hashcode()메서드 자동완성
//@NoArgsConstructor : 기본생성자
public class ArticleForm {
	private String title;
	private String content;

	//DTO클래스에 데이터를 Entity(table과 매핑되는 클라스)로
	//변환하는 메서드를 추가함
	public Article toEntity() {
		return new Article(null,title,content);
	}
	
}
