package com.teste.blog.controller.dto;

public class PostDto {

	public String text;
	public String imageUrl;
	public String linkUrl;
	
	public PostDto() {	
	}
	
	public PostDto(String text, String imageUrl, String linkUrl) {
		super();
		this.text = text;
		this.imageUrl = imageUrl;
		this.linkUrl = linkUrl;
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
