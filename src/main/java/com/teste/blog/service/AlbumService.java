package com.teste.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.teste.blog.controller.dto.AlbumDto;
import com.teste.blog.controller.dto.PictureDto;
import com.teste.blog.controller.resp.AlbumResp;
import com.teste.blog.controller.resp.PictureResp;
import com.teste.blog.model.Album;
import com.teste.blog.model.Picture;
import com.teste.blog.model.Users;
import com.teste.blog.repository.AlbumRepository;
import com.teste.blog.repository.PictureRepository;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private PictureRepository pictureRepository;

    public Page<AlbumResp> lastAlbums(Pageable pageable) {
    	
        Page<Album> albumsPage = albumRepository.findAll(pageable);
        return mapPageToAlbumRespPage(albumsPage);
    }

    public Page<AlbumResp> mapPageToAlbumRespPage(Page<Album> albumsPage) {
        return albumsPage.map(this::mapToAlbumResp);
    }

    public AlbumResp mapToAlbumResp(Album album) {
    	
        AlbumResp albumResp = new AlbumResp();
        albumResp.setAlbum_id(album.getId());
        albumResp.setTitle(album.getTitle());
        
        return albumResp;
    }

    public void createAlbum(Users user, AlbumDto dto) {
    	
        Album album = new Album(user, dto.getTitle());
        albumRepository.save(album);
    }

    public void deleteAlbum(Users user, Long albumId) {
    	
    	List<Picture> list = pictureRepository.findByAlbumId(albumId);
		
		if( !list.isEmpty() ) pictureRepository.deleteAll(list);
    	
        Album album = albumRepository.findByUserAndId(user.getId(), albumId);
        
        if (album != null) albumRepository.delete(album);
    }

    public Page<PictureResp> lastPictures(Long albumId, Pageable pageable) {
    	
        Page<Picture> picturesPage = pictureRepository.findByAlbumId(albumId, pageable);
        
        return mapPageToPictureRespPage(picturesPage);
    }

    public Page<PictureResp> mapPageToPictureRespPage(Page<Picture> picturesPage) {
    	
        return picturesPage.map(this::mapToPictureResp);
    }

    public PictureResp mapToPictureResp(Picture picture) {
    	
        PictureResp pictureResp = new PictureResp();
        pictureResp.setPicture_id(picture.getId());
        pictureResp.setImageUrl(picture.getImageUrl());

        return pictureResp;
    }

    public void createPicture(Users user, PictureDto dto) {
    	
        Album album = albumRepository.findByUserAndId(user.getId(), dto.getAlbumId());
        
        if (album != null) {
        	
            Picture picture = new Picture(dto.getImageUrl(), user, album);
            pictureRepository.save(picture);
        }
    }

    public void deletePicture(Users user, Long pictureId) {
    	
        Picture picture = pictureRepository.findByUserAndId(user.getId(), pictureId);
        
        if (picture != null) pictureRepository.delete(picture);
    }
}
