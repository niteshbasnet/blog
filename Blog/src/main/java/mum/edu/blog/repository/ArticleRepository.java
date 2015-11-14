package mum.edu.blog.repository;

import mum.edu.blog.domain.Article;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	public Article findArticleById(long id);
	
}
