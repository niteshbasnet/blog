package mum.edu.blog.repository;

import java.util.List;

import mum.edu.blog.domain.Article;
import mum.edu.blog.domain.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	Comment findCommentById(long Id);

	List<Comment> findCommentByArticle(Article article);

}
