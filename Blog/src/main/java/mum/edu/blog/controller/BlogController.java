package mum.edu.blog.controller;

import mum.edu.blog.repository.ArticleRepository;
import mum.edu.blog.repository.BlogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {

	@Autowired
	BlogRepository blogRepository;

	@Autowired
	ArticleRepository articleRepository;

	@RequestMapping("/blogHome")
	public String findBlog(Model model) {
		model.addAttribute("articles", articleRepository.findAll());
		return "blogHome";
	}
}
