package mum.edu.blog.service;

import mum.edu.blog.domain.Blog;
import mum.edu.blog.repository.BlogRepository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

	private final static Logger LOGGER = Logger.getLogger(BlogService.class);

	@Autowired
	private BlogRepository blogRepository;

	public Blog findBlogById(long id) {
		LOGGER.debug("blog service:: findblogbyid called");
		return blogRepository.findBlogById(id);
	}
}
