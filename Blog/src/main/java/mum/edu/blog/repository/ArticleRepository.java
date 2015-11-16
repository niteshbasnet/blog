package mum.edu.blog.repository;

import java.util.List;

import mum.edu.blog.domain.Article;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long>{

	public Article findArticleById(long id);
	
	public List<Article> findArticleByTags(String tag);
}
