package mum.edu.blog.controller;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;

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
	public String addArticle(@ModelAttribute Article article, RedirectAttributes redirect) {
		Date date= new java.util.Date();
		article.setDate(new Timestamp(date.getTime()));
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
		redirect.addFlashAttribute("articles", articleRepository.findAll());
		return "redirect:/blogHome";
	}

	@RequestMapping(value = { "/articleDetail/{id}" }, method = RequestMethod.GET)
	public String articleDetail(@PathVariable("id") long articleId, Model model) {
		Article article = articleRepository.findArticleById(articleId);
		model.addAttribute("comments",commentRepository.findCommentByArticle(article));
		model.addAttribute("article", article);
		model.addAttribute("comment",new Comment());
		return "articleDetail";
	}
	
	@RequestMapping(value = { "/{id}/addComment" }, method = RequestMethod.POST)
	public String articleComment(@PathVariable("id") long articleId, @ModelAttribute Comment comment, Model model) {
		Date date= new java.util.Date();
		commentRepository.insertComment(comment.getComment(), new Timestamp(date.getTime()), articleId);
		return "redirect:/article/articleDetail/"+articleId;
	}

	@RequestMapping(value = { "/tag/{tag}" }, method = RequestMethod.GET)
	public String articlesByTag(@PathVariable("tag") String tag, Model model) {
		model.addAttribute("articles", articleService.findArticlesByTag(tag));
		return "blogHome";
	}
	
}
