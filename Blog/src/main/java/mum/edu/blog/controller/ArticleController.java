package mum.edu.blog.controller;

import java.io.File;

import mum.edu.blog.domain.Article;
import mum.edu.blog.service.ArticleService;
import mum.edu.blog.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	ArticleService articleService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String articleHome(@ModelAttribute Article article) {
		return "addArticle";
	}

	@RequestMapping(value = { "/addArticle" }, method = RequestMethod.GET)
	public String addArticle(@ModelAttribute Article article) {
		return "addArticle";
	}

	@RequestMapping(value = { "/addArticle" }, method = RequestMethod.POST)
	public String addArticle(@ModelAttribute Article article, Model model) {

		MultipartFile studentImage = article.getArticleImg();
		if (studentImage != null && !studentImage.isEmpty()) {
			try {
				System.out.println("addimage try");
				studentImage.transferTo(new File("d:\\images\\article_image\\"
						+ article.getId() + ".png"));

				article.setArticleImage("d:\\images\\article_image\\"
						+ article.getId() + ".png");
			} catch (Exception e) {
				throw new RuntimeException("Article Image saving failed", e);
			}
		}

		articleRepository.save(article);
		model.addAttribute("articles", articleRepository.findAll());
		return "redirect:/blogHome";
	}

	@RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
	public String articleDetail(@PathVariable("id") long id, Model model) {
		model.addAttribute("article", articleRepository.findArticleById(id));
		return "articleDetail";
	}

	@RequestMapping(value = { "/tag/{tag}" }, method = RequestMethod.GET)
	public String articlesByTag(@PathVariable("tag") String tag, Model model) {
		model.addAttribute("articles", articleService.findArticlesByTag(tag));
		return "blogHome";
	}
}
