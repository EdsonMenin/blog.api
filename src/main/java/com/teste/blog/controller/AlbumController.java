package com.teste.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.blog.controller.dto.AlbumDto;
import com.teste.blog.controller.dto.PictureDto;
import com.teste.blog.controller.resp.AlbumResp;
import com.teste.blog.controller.resp.PictureResp;
import com.teste.blog.model.Users;
import com.teste.blog.service.AlbumService;
import com.teste.blog.service.UserService;

@RestController
@RequestMapping("/albums")
public class AlbumController {

	@Autowired
	private UserService userService;
	
	@Autowired
    private AlbumService albumService;
	
	@Autowired
	private HttpServletRequest request;

	@GetMapping("/lastAlbuns")
	public ResponseEntity<Object> lastAlbuns( @RequestHeader(defaultValue = "0") int page,
											  @RequestHeader(defaultValue = "10") int size) {
	    try {
	    	
	        Pageable pageable = PageRequest.of(page, size);
	        Page<AlbumResp> postsPage = albumService.lastAlbuns(pageable);

	        return new ResponseEntity<>(postsPage, HttpStatus.OK);
	        
	    } catch (Exception e) {
	        return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PostMapping("/createAlbum")
	public ResponseEntity<Object> createAlbum( @RequestBody AlbumDto dto ) {
		
		try {
			
			Users user = userService.retrieveUser(request);
			
			if( user == null ) {
				return new ResponseEntity<Object>("Não Autorizado!", HttpStatus.UNAUTHORIZED);
			}

			albumService.createAlbum(user, dto);
			
			return  new ResponseEntity<Object>( "Album cadastrado com sucesso!", HttpStatus.OK);
		
		} catch (Exception e) {
			return new ResponseEntity<Object>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteAlbum")
	public ResponseEntity<Object> deleteAlbum( @RequestHeader Long albumId ) {
		
		try {
			
			Users user = userService.retrieveUser(request);
			
			if( user == null ) {
				return new ResponseEntity<Object>("Não Autorizado!", HttpStatus.UNAUTHORIZED);
			}

			albumService.deleteAlbum(user, albumId);
			
			return  new ResponseEntity<Object>( "Album removido com sucesso!", HttpStatus.OK);
		
		} catch (Exception e) {
			return new ResponseEntity<Object>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/lastPictures")
	public ResponseEntity<Object> lastPictures( @RequestHeader Long albumId,
											  @RequestHeader(defaultValue = "0") int page,
											  @RequestHeader(defaultValue = "10") int size) {
	    try {
	    	
	        Pageable pageable = PageRequest.of(page, size);
	        Page<PictureResp> postsPage = albumService.lastPictures(albumId, pageable);

	        return new ResponseEntity<>(postsPage, HttpStatus.OK);
	        
	    } catch (Exception e) {
	        return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PostMapping("/createPicture")
	public ResponseEntity<Object> createPicture( @RequestBody PictureDto dto ) {
		
		try {
			
			Users user = userService.retrieveUser(request);
			
			if( user == null ) {
				return new ResponseEntity<Object>("Não Autorizado!", HttpStatus.UNAUTHORIZED);
			}

			albumService.createPicture(user, dto);
			
			return  new ResponseEntity<Object>( "Album cadastrado com sucesso!", HttpStatus.OK);
		
		} catch (Exception e) {
			return new ResponseEntity<Object>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deletePicture")
	public ResponseEntity<Object> deletePicture( @RequestHeader Long pictureId ) {
		
		try {
			
			Users user = userService.retrieveUser(request);
			
			if( user == null ) {
				return new ResponseEntity<Object>("Não Autorizado!", HttpStatus.UNAUTHORIZED);
			}

			albumService.deletePicture(user, pictureId);
			
			return  new ResponseEntity<Object>( "Album removido com sucesso!", HttpStatus.OK);
		
		} catch (Exception e) {
			return new ResponseEntity<Object>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
   
}

