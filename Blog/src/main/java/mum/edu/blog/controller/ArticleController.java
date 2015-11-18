package mum.edu.blog.controller;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import mum.edu.blog.domain.Article;
import mum.edu.blog.domain.Comment;
import mum.edu.blog.repository.ArticleRepository;
import mum.edu.blog.repository.CommentRepository;
import mum.edu.blog.service.ArticleService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	private final static Logger LOGGER = Logger.getLogger(ArticleController.class);
	
	@Value("${image.path}")
	private String path;
	
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
		LOGGER.info("article id:::::"+article.toString());
		Date date= new java.util.Date();
		article.setDate(new Timestamp(date.getTime()));
		MultipartFile articleImg = article.getArticleImg();
		if (articleImg != null && !articleImg.isEmpty()) {
			try {
				articleImg.transferTo(new File(path+ article.getId() + ".png"));
				article.setArticleImage(path+ article.getId() + ".png");
			} catch (Exception e) {
				throw new RuntimeException("Article Image saving failed", e);
			}
		}

		articleRepository.save(article);
		redirect.addFlashAttribute("articles", articleRepository.findAll());
		return "redirect:/";
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
	
	@RequestMapping(value="/getArticles", method=RequestMethod.GET)
	public @ResponseBody Article getArticles(){
		LOGGER.info("getArticles:::::"+articleService.findArticleById(1));
		return articleService.findArticleById(1);
	}
	
}
