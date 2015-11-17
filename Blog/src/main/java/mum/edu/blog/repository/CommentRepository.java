package mum.edu.blog.repository;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import mum.edu.blog.domain.Article;
import mum.edu.blog.domain.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	public Comment findCommentById(long Id);

	public List<Comment> findCommentByArticle(Article article);

	@Modifying
	@Transactional
	@Query(value = "insert into comment(COMMENT,CMT_DATE,ART_ID) values (?1,?2,?3)", nativeQuery = true)
	public void insertComment(String comment, Timestamp date, long articleId);

}
