package com.teste.blog.controller.resp;

public class CommentResp {

	private Long comment_id;
	private String text;
	
	public CommentResp() {
		
	}

	public CommentResp(Long comment_id, String text) {
		super();
		this.comment_id = comment_id;
		this.text = text;
	}

	public Long getComment_id() {
		return comment_id;
	}

	public void setComment_id(Long comment_id) {
		this.comment_id = comment_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	 
}
