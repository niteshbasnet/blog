package mum.edu.blog.controller;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mum.edu.blog.domain.Blog;
import mum.edu.blog.domain.User;
import mum.edu.blog.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;
	
	public MainController() {
		// TODO Auto-generated constructor stub
	}
	@PostConstruct
	void testData()
	{
		User user = new User();
		user.setAuthority("ROLE_USER");
		user.setUsername("bold");
		user.setFirstName("bold F");
		user.setLastName("bold L");
		user.setPassword("pass");
		user.setEnabled(true);
		user.setBirthDate(new Date());
		user.setEmail("maildsf@mail.com");
		
		Blog blog = new Blog();
		
		blog.setBlogName("boldkhuu");
		blog.setTitle("title");
		
		user.addBlog(blog);
		
		userService.save(user);
	}

	@RequestMapping("/")
	public String home(Model model) {
		return "redirect:/blog";
	}

}
