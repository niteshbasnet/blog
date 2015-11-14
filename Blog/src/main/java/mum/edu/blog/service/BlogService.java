package mum.edu.blog.service;

import mum.edu.blog.domain.Blog;
import mum.edu.blog.repository.BlogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;

	public Blog findBlogById(long id) {
		return blogRepository.findBlogById(id);
	}
}
