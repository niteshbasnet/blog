package mum.edu.blog.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "ARTICLE")
public class Article implements Serializable {

	private static final long serialVersionUID = -4301585239329431807L;	
	
	public Article() {
	}

	public Article(String title, String content, String articleImage,
			MultipartFile articleImg, List<String> tags, Date date, Blog blog,
			List<Comment> comment) {
		this.title = title;
		this.content = content;
		this.articleImage = articleImage;
		this.articleImg = articleImg;
		this.tags = tags;
		this.date = date;
		this.blog = blog;
		this.comment = comment;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ART_ID")
	private long id;
	
	@Column(name = "TITLE")
	private String title;

	@Column(name = "CONTENT")
	private String content;

	@Column(name = "ART_IMG")
	private String articleImage;

	@Transient
	private MultipartFile articleImg;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "ART_TAG")
	private List<String> tags;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd.MM")
	@Column(name = "POST_DATE")
	private Date date;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BLG_ID")
	private Blog blog;

	@OneToMany(mappedBy = "article",fetch=FetchType.LAZY)
	private List<Comment> comment;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getArticleImage() {
		return articleImage;
	}

	public void setArticleImage(String articleImage) {
		this.articleImage = articleImage;
	}

	public MultipartFile getArticleImg() {
		return articleImg;
	}

	public void setArticleImg(MultipartFile articleImg) {
		this.articleImg = articleImg;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public void addComment(Comment comment){
		comment.setArticle(this);
		this.comment.add(comment);
	}
}