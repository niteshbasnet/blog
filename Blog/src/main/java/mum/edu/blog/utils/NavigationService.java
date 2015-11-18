package mum.edu.blog.utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mum.edu.blog.domain.Article;
import mum.edu.blog.domain.Blog;
import mum.edu.blog.repository.ArticleRepository;
import mum.edu.blog.repository.BlogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class NavigationService {
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private BlogRepository blogRepository;

	public List<Navigation> navList() {
	    HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	    HttpSession session = httpServletRequest.getSession();
	    long blogid = (Long)session.getAttribute("blogid");
		Blog blog = blogRepository.findBlogById((blogid));
		List<Article> articleList = articleRepository.findArticleByBlog(blog);
		List<Navigation> navList = new ArrayList<Navigation>();
		if (articleList != null && !articleList.isEmpty()) {			
			for (Article article : articleList) {
				navList.add(new Navigation(article.getTitle(), "/blog/"+ blogid + "/articleDetail/" + article.getId()));
			}
		} else {
			navList.add(new Navigation("No Articles","#"));
		}
		return navList;
	}
}
