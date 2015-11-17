package mum.edu.blog.service;

import java.util.List;

import mum.edu.blog.domain.Article;
import mum.edu.blog.domain.Blog;
import mum.edu.blog.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

	@Autowired
	ArticleRepository articleRepository;

	public Article findArticleById(long id) {
		return articleRepository.findArticleById(id);
	}

	public List<Article> findArticlesByTag(String tag) {
		return articleRepository.findArticleByTags(tag);
	}

	public List<Article> findArticleByBlog(Blog blog) {
		return articleRepository.findArticleByBlog(blog);
	}

	public Article findArticleByBlogAndId(Blog blog, long articleId) {
		return articleRepository.findArticleByBlogAndId(blog, articleId);
	}
}
