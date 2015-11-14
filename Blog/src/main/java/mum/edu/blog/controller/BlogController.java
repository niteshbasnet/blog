package mum.edu.blog.controller;

import mum.edu.blog.repository.BlogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

	@Autowired
	BlogRepository blogRepository;

	public ModelAndView findBlog(long id, ModelAndView mav) {
		mav.addObject("blog", blogRepository.findBlogById(1));
		mav.setViewName("home");
		return mav;
	}
}
