package mum.edu.blog.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import mum.edu.blog.domain.Article;
import mum.edu.blog.domain.Blog;
import mum.edu.blog.domain.Comment;
import mum.edu.blog.domain.User;
import mum.edu.blog.service.ArticleService;
import mum.edu.blog.service.BlogService;
import mum.edu.blog.service.CommentService;
import mum.edu.blog.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/blog")
//@SessionAttributes("userName")
public class BlogController {
	private long blogid = 1L;
	@Autowired
	BlogService blogService;

	@Autowired
	UserService userService;

	@Autowired
	ArticleService articleService;
	
	@Autowired
	CommentService commentService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String findBlog(Model model, Principal principal) {
		//String name = principal.getName();
		Blog blog = blogService.findBlogById(blogid);
		model.addAttribute("articles",articleService.findArticleByBlog(blog));
		//model.addAttribute("userName", name);
		model.addAttribute("blogid", blogid);
		return "blogHome";
	}
	
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/createblog", method = RequestMethod.GET)
	public String createBlog(@ModelAttribute("newblog") Blog blog) {
		return "createBlog";
	}
	
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/createblog", method = RequestMethod.POST)
	public String saveBlog(@ModelAttribute("newblog") @Valid Blog blog, BindingResult result, Principal principal) {
		if(result.hasErrors()) return "CreateBlog";
		
		if(blogService.findByBlogName(blog.getBlogName()) != null) 
		{
			result.rejectValue("blogName","error.unique", "BlogName already exists. Please change.");
			return "createBlog";
		}

		User user = userService.findByUsername(principal.getName());
		System.out.println(user.getFirstName());
		user.addBlog(blog);
		userService.save(user);
		//blogService.save(blog);
		
		
		return "redirect:/blog";
	}
	
	@RequestMapping("{blogid}/{articleid}")
	public String findArticleByBlog(@PathVariable("blogid") long blogId, @PathVariable("articleid") long articleId, 
			@ModelAttribute Comment comment, Model model){
		Blog blog = blogService.findBlogById(blogId);
		Article article = articleService.findArticleByBlogAndId(blog, articleId);
		model.addAttribute("comments",commentService.findCommentByArticle(article));
		model.addAttribute("article", article);
		return "articleDetail";
	}
}
