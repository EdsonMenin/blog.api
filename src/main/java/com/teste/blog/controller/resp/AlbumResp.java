package com.teste.blog.controller.resp;

public class AlbumResp {

	public Long album_id;
	public String title;
	
	public AlbumResp() {	
	}

	public AlbumResp(Long album_id, String title) {
		super();
		this.album_id = album_id;
		this.title = title;
	}

	public Long getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(Long album_id) {
		this.album_id = album_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
