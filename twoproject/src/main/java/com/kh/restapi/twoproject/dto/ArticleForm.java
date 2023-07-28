package com.kh.restapi.twoproject.dto;


import com.kh.restapi.twoproject.entity.Article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor // 기본 생성자 자동 완성
@AllArgsConstructor // 모든 변수를 사용하는 생성자 자동 완성
@Getter // getter 메소드 자동 완성
@Setter // setter 메소드 자동 완성
@ToString // toString() 메소드 자동 완성
@EqualsAndHashCode // equals() 메소드와 hashcode() 메소드 자동 완성
@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode 자동 완성
public class ArticleForm {
	private Long id;
	private String title;
	private String content;
	
	//DTO 클래스에 데이터를 Entity(테이블과 매핑되는 클래스)로 변환하는 메소드를 추가한다.
		public Article toEntity() {
			return new Article(id, title, content);//객체생성
		}
}
