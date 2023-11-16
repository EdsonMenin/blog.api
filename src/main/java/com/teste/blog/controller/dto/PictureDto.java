package com.teste.blog.controller.dto;

public class PictureDto {

	public String albumId;
	public String imageUrl;
	
	public PictureDto() {	
	}

	public PictureDto(String albumId, String imageUrl) {
		super();
		this.albumId = albumId;
		this.imageUrl = imageUrl;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
