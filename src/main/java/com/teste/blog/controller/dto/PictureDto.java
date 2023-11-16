package com.teste.blog.controller.dto;

public class PictureDto {

	public Long albumId;
	public String imageUrl;
	
	public PictureDto() {	
	}

	public PictureDto(Long albumId, String imageUrl) {
		super();
		this.albumId = albumId;
		this.imageUrl = imageUrl;
	}

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
