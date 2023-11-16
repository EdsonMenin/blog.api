package com.teste.blog.controller.dto;

public class AlbumDto {

	public String title;
	
	public AlbumDto() {	
	}

	public AlbumDto(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
