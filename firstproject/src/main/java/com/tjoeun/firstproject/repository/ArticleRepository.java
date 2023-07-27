package com.tjoeun.firstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjoeun.firstproject.entity.Article;

//	SpringBoot의 JPA에서 Entity의 기본적인 CRUD가 가능하도록 Repository를 제공한다.
//	JPA는 데이터베이스에 적용할 메소드를 정의해 놓고 SpringBoot가 Repository의 내부 구현체를 자동으로 생성시켜
//	주기 때문에 별도의 구현체를 따로 생성하지 않고 메소드를 호출하는 것만으로 데이터베이스에 적용할 메소드를
//	사용할 수 있게 된다.

//	JpaRepository 인터페이스를 상속받아 repository로 사용할 인터페이스를 선언한다.
//	JpaRepository 인터페이스는 2개의 제네릭을 인수로 받아야 하는데 첫 번째 인수는 Entity로 사용할 클래스를
//	두 번째 인수는 기본키로 사용할 필드의 데이터 타입을 적는다.
public interface ArticleRepository extends JpaRepository<Article, Long> {
	
}
