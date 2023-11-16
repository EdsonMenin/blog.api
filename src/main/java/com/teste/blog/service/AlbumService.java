package com.teste.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.blog.repository.AlbumRepository;
import com.teste.blog.repository.PictureRepository;

@Service
public class AlbumService {
	
	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired
	private PictureRepository pictureRepository;

}
