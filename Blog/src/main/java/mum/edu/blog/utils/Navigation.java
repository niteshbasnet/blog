package mum.edu.blog.utils;

public class Navigation {

	private String linkName;
	private String linkURL;

	public Navigation(String linkName, String linkURL) {
		this.linkName = linkName;
		this.linkURL = linkURL;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getLinkURL() {
		return linkURL;
	}

	public void setLinkURL(String linkURL) {
		this.linkURL = linkURL;
	}

}
