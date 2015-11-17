package mum.edu.blog.utils;

import java.util.ArrayList;
import java.util.List;

import mum.edu.blog.domain.Article;
import mum.edu.blog.domain.Blog;
import mum.edu.blog.repository.ArticleRepository;
import mum.edu.blog.repository.BlogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NavigationService {
	private long blogid = 1L;
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private BlogRepository blogRepository;

	public List<Navigation> navList() {
		Blog blog = blogRepository.findBlogById(blogid);
		List<Article> articleList = articleRepository.findArticleByBlog(blog);
		List<Navigation> navList = new ArrayList<Navigation>();
		for (Article article : articleList) {
			navList.add(new Navigation(article.getTitle(),"/blog/"+blogid+"/articleDetail/"+article.getId()));
		}
		return navList;
	}
}
