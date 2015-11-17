package mum.edu.blog.repository;

import mum.edu.blog.domain.Blog;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BlogRepository extends JpaRepository<Blog, Long>{

	public Blog findBlogById(long id);
	
	@Query("select b from Blog b INNER JOIN b.userList u where u.id=:id")
	public List<Blog> getUserBlogs(@Param("id") long id);

}
