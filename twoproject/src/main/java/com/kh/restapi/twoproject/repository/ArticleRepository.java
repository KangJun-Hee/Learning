package com.kh.restapi.twoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.restapi.twoproject.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{

}
