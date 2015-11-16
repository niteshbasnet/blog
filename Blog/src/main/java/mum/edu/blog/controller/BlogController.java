package mum.edu.blog.controller;

import java.security.Principal;

import mum.edu.blog.domain.Blog;
import mum.edu.blog.service.ArticleService;
import mum.edu.blog.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/blog")
@SessionAttributes("userName")
public class BlogController {
	private long blogid = 1L;
	@Autowired
	BlogService blogService;

	@Autowired
	ArticleService articleService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String findBlog(Model model, Principal principal) {
		String name = principal.getName();
		Blog blog = blogService.findBlogById(blogid);
		model.addAttribute("articles",articleService.findArticleByBlog(blog));
		model.addAttribute("userName", name);
		model.addAttribute("blogid", blogid);
		return "blogHome";
	}
	
	@RequestMapping("{blogid}/{articleid}")
	public String findArticleByBlog(@PathVariable("blogid") long blogId, @PathVariable("articleid") long articleId, Model model){
		Blog blog = blogService.findBlogById(blogId);
		model.addAttribute("article",articleService.findArticleByBlogAndId(blog, articleId));
		return "articleDetail";
	}
}
