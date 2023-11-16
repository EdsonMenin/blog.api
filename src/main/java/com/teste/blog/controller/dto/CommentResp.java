package com.teste.blog.controller.dto;

public class CommentResp {

	private Long post_id;
	private String text;
	
	public CommentResp() {
		
	}
	
	public CommentResp(Long post_id, String text) {
		super();
		this.post_id = post_id;
		this.text = text;
	}

	public Long getPost_id() {
		return post_id;
	}

	public void setPost_id(Long post_id) {
		this.post_id = post_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	 
}
