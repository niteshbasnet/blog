package mum.edu.blog.repository;

import java.util.List;

import mum.edu.blog.domain.Article;
import mum.edu.blog.domain.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	public Comment findCommentById(long Id);

	public List<Comment> findCommentByArticle(Article article);

	@Query(value = "insert into Comment(COMMENT,ART_ID) values (?comment, ?articleId)", nativeQuery = true)
	public void saveComment(String comment, long articleId);

}
