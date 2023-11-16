package com.teste.blog.controller.resp;

public class PictureResp {

	public Long picture_id;
	public String imageUrl;
	
	public PictureResp() {	
	}

	public PictureResp(Long picture_id, String imageUrl) {
		super();
		this.picture_id = picture_id;
		this.imageUrl = imageUrl;
	}

	public Long getPicture_id() {
		return picture_id;
	}

	public void setPicture_id(Long picture_id) {
		this.picture_id = picture_id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
