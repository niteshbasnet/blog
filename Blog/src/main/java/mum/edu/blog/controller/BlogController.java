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
		
		model.addAttribute("articles",articleService.findAll());
		
		System.out.println("===================="+principal);
		if(principal !=null){
			User user = userService.findByUsername(principal.getName());
			
			if(user !=null) 
			{
				model.addAttribute("userBlogs", blogService.userBlogs(user.getId()));
			}
		}
		return "home";
	}
	
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/createblog", method = RequestMethod.GET)
	public String createBlog(@ModelAttribute("newblog") Blog blog) {
		return "createBlog";
	}
	
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/createblog", method = RequestMethod.POST)
	public String saveBlog(@ModelAttribute("newblog") @Valid Blog blog, BindingResult result, Principal principal) {
		if(result.hasErrors()) return "createBlog";
		
		if(blogService.findByBlogName(blog.getBlogName()) != null) 
		{
			result.rejectValue("blogName","error.unique", "BlogName already exists. Please change.");
			return "createBlog";
		}

		if(principal != null){
			User user = userService.findByUsername(principal.getName());
			
			user.addBlog(blog);
			userService.save(user);
			
			return "redirect:/blog";
		}
		
		return "error-forbidden";
		
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
	@RequestMapping("/{blogname}")
	public String Showblog(@PathVariable("blogname") String blogName, Model model){
		Blog blog = blogService.findByBlogName(blogName);
		model.addAttribute("articles",articleService.findArticleByBlog(blog));
		
		return "blogHome";
	}
}
