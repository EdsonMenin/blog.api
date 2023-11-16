package com.teste.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.teste.blog.controller.dto.AlbumDto;
import com.teste.blog.controller.dto.PictureDto;
import com.teste.blog.controller.resp.AlbumResp;
import com.teste.blog.controller.resp.PictureResp;
import com.teste.blog.model.Users;
import com.teste.blog.repository.AlbumRepository;
import com.teste.blog.repository.PictureRepository;

@Service
public class AlbumService {
	
	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired
	private PictureRepository pictureRepository;

	public Page<AlbumResp> lastAlbuns(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createAlbum(Users user, AlbumDto dto) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAlbum(Users user, Long albumId) {
		// TODO Auto-generated method stub
		
	}
	
	public Page<PictureResp> lastPictures(Long albumId, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createPicture(Users user, PictureDto dto) {
		// TODO Auto-generated method stub
		
	}

	public void deletePicture(Users user, Long pictureId) {
		// TODO Auto-generated method stub
		
	}
}
