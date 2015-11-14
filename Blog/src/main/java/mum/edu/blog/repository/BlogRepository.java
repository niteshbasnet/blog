package mum.edu.blog.repository;

import mum.edu.blog.domain.Blog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long>{

	public Blog findBlogById(long id);
}
