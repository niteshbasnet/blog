package mum.edu.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.blog.domain.Article;
import mum.edu.blog.domain.Comment;
import mum.edu.blog.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	CommentRepository commentRepository;

	public Comment findCommentById(long id) {
		return commentRepository.findCommentById(id);
	}

	public List<Comment> findCommentByArticle(Article article) {
		return commentRepository.findCommentByArticle(article);
	}
}
