package mum.edu.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import mum.edu.blog.domain.Comment;


public interface CommentRepository extends JpaRepository<Comment,Long>{
	Comment findCommentById(long Id);
	
}
