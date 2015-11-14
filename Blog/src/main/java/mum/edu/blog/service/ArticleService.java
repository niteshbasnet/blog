package mum.edu.blog.service;

import mum.edu.blog.domain.Article;
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
}
