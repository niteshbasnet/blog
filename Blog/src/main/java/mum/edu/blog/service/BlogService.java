package mum.edu.blog.service;

import mum.edu.blog.domain.Blog;
import mum.edu.blog.domain.User;
import mum.edu.blog.repository.BlogRepository;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BlogService {

	private final static Logger LOGGER = Logger.getLogger(BlogService.class);

	@Autowired
	private BlogRepository blogRepository;

	public Blog findBlogById(long id) {
		LOGGER.debug("blog service:: findblogbyid called");
		return blogRepository.findBlogById(id);
	}
	
	public Blog save(Blog blog) {
		LOGGER.debug("blog service:: blog save called");
		return blogRepository.save(blog);
	}
	
	public List<Blog> userBlogs(long id)
	{
		return blogRepository.getUserBlogs(id);
	}
	public Blog findByBlogName(String blogname)
	{
		return blogRepository.findFirstBlogByBlogName(blogname);
	}
}
