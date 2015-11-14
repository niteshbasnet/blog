package mum.edu.blog.controller;

import mum.edu.blog.domain.Article;
import mum.edu.blog.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArticleController {

	@Autowired
	ArticleRepository articleRepository;

	@RequestMapping(value = { "addArticle" }, method = RequestMethod.GET)
	public String addArticle(@ModelAttribute Article article) {
		return "addArticle";
	}

	@RequestMapping(value = { "addArticle" }, method = RequestMethod.POST)
	public String addArticle(@ModelAttribute Article article, Model model) {
		articleRepository.save(article);
		return "addArticle";
	}
}
