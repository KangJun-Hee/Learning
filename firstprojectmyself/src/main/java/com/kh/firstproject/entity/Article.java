package com.kh.firstproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//ORM (Object RelationMapping) : 객체와 DB 매핑을 이룸
//	객체가 테이블이 되도록 매핑시키는 프레임워크
//	프로그램 복잡도 줄이고 자바객체와 쿼리를 분리가능
//	프랜젝션처리,DB관련작업들 좀 더 간편히 처리가능
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//JPA (Java Persistence Api):ORM을 사용위한 인터페이스 모아둔 것
//	자바어플리케이션서 DB사용하는 방식을 정의한 인터페이스

//Hibernate : JPA사용하기 위해 구현한 ORM프레임워크 중 하나


//JPA를 사용해 테이블과 매핑할 클라스는 @Entity어노테이션은 필수임
//@Entity anotation이 붙은 클라스명으로 springboot가 자동으로
//	테이블 만들고 클라스내부에 선언한 필드명으로 테이블 구성하는 컬럼 만듦
@Entity

@NoArgsConstructor //기본생성자
@AllArgsConstructor//모든변수 사용하는 생성자
@EqualsAndHashCode//equals()hashcode()메서드 자동완성

@Getter
@ToString
public class Article {
	//기본키(primary key)로 사용할 필드선언
	//	"			 를 자동으로 생성하려면
	
	
	//기본키값 자동생성(시퀀스가 무조건 1부터 시작함)
	@Id//필드를 기본키로 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//table column과 매핑한다
	@Column
	private String title;
	@Column
	private String content;

	
	
//이것들 생성을 어노테이션이 대신 해 줌
//	public Article() {}
//	public Article(Long id, String title, String content) {
//		super();
//		this.id = id;
//		this.title = title;
//		this.content = content;
//	}
//	@Override
//	public String toString() {
//		return "[id=" + id + ", title=" + title + ", content=" + content + "]";
//	}
}

//h2 DataBase
//	웹용 콘솔(쿼리들) 제공해 개발용 로컬DB다
//	인메모리 DB라고도 함 디스크가 아니라 메인 메모리에
//		모든 데이터를 저장하는 DB
//	모든 걸 메인에 저장하니 자료에 접근은 빠르다, 
//		서버를 끄면 전부 날아감

















