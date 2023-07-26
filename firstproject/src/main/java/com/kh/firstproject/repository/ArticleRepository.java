package com.kh.firstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.firstproject.entity.Article;

//Spring boot's jpa, Entity의 기본적 CRUD가 가능하도록 Repository를 제공한다
//JPA는 DB에 적용할 메소드 정의 후 spring boo가 Repository의 내부구현체를 자동생성함
//	별도 구현체를 따로 생성 안 하고 메서드를 호출하는 것만으로도, DB에 적용할 메서드 사용가능

//JpaRepository 인터페이스를 상속받아 Repository로 사용할 인터페이스 선언함
public interface ArticleRepository extends JpaRepository<Article, Long>{

}