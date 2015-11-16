package mum.edu.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.json.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import mum.edu.blog.domain.Comment;

import mum.edu.blog.repository.CommentRepository;

@Controller
public class CommentController {
	@Autowired
	CommentRepository commentRepository;
	

	@RequestMapping(value = { "/addComment" }, method = RequestMethod.GET)
	public String addComment(@ModelAttribute Comment comment) {
		
		  return "addComment";
	}

	@RequestMapping(value = { "/addComment" }, method = RequestMethod.POST)
	public String addComment(@ModelAttribute Comment comment,Model model) {
		commentRepository.save(comment);
		return "addComment";
	}

}
