package mum.edu.blog.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "BLOG")
public class Blog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1348453764392672567L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BLG_ID")
	private long id;

	@Column(name = "TITLE")
	private String title;
	
	@Pattern(regexp = "[a-zA-Z0-9_-]+")
	@Column(unique=true)
	private String blogName;

	@Column(name = "DESCP")
	private String description;

//	@ManyToMany(mappedBy="blogList")
//	private List<User> userList = new ArrayList<>();
//	
	@OneToMany(mappedBy = "blog", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Article> articleList=new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

//	public List<User> getUserList() {
//		return userList;
//	}
//
//	public void setUserList(List<User> userList) {
//		this.userList = userList;
//	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
	
	public void addArticle(Article article) {
		this.articleList.add(article);
	}
	
	
}