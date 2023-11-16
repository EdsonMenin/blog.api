package com.teste.blog.controller.resp;

public class PostResp {

	public Long id;
	public Long userId;
	public String text;
	public String imageUrl;
	public String linkUrl;
	
	public PostResp() {	
	}

	public PostResp(Long id, Long userId, String text, String imageUrl, String linkUrl) {
		super();
		this.id = id;
		this.userId = userId;
		this.text = text;
		this.imageUrl = imageUrl;
		this.linkUrl = linkUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
}
