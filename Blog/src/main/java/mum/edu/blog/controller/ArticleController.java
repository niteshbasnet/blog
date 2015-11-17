package mum.edu.blog.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import mum.edu.blog.domain.Article;
import mum.edu.blog.domain.Comment;
import mum.edu.blog.repository.ArticleRepository;
import mum.edu.blog.repository.CommentRepository;
import mum.edu.blog.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	ArticleService articleService;

	@Autowired
	CommentRepository commentRepository;
	
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
	public String articleDetail(@PathVariable("id") long articleId, @ModelAttribute Comment comment, Model model) {
		Article article = articleRepository.findArticleById(articleId);
		model.addAttribute("comments",commentRepository.findCommentByArticle(article));
		model.addAttribute("article", article);
		return "articleDetail";
	}
	
	@RequestMapping(value = { "/{id}/addComment" }, method = RequestMethod.POST)
	public String articleComment(@PathVariable("id") long articleId, @ModelAttribute Comment comment, RedirectAttributes redirect) {		
		Article article = articleService.findArticleById(articleId);
		comment.setArticle(article);
		List<Comment> commentList = new ArrayList<Comment>();
		article.setComment(commentList);
		commentRepository.save(comment);
		redirect.addFlashAttribute("comments",commentRepository.findCommentByArticle(article));
		redirect.addFlashAttribute("article", article);
		return "redirect:articleDetail";
	}

	@RequestMapping(value = { "/tag/{tag}" }, method = RequestMethod.GET)
	public String articlesByTag(@PathVariable("tag") String tag, Model model) {
		model.addAttribute("articles", articleService.findArticlesByTag(tag));
		return "blogHome";
	}
	
}
