package com.teste.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.blog.controller.dto.PostDto;
import com.teste.blog.model.Users;
import com.teste.blog.service.PostService;
import com.teste.blog.service.UserService;


@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private HttpServletRequest request;
	
	@PostMapping("/createPost")
	public ResponseEntity<Object> createPost( @RequestBody PostDto dto ) {
		
		try {
			
			Users user = userService.retrieveUser(request);
			
			if( user == null ) {
				return new ResponseEntity<Object>("Não Autorizado!", HttpStatus.UNAUTHORIZED);
			}

			postService.createPost(user, dto);
			
			return  new ResponseEntity<Object>( "Post cadastrado com sucesso!", HttpStatus.OK);
		
		} catch (Exception e) {
			return new ResponseEntity<Object>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deletePost")
	public ResponseEntity<Object> deletePost( @RequestHeader Long postId ) {
		
		try {
			
			Users user = userService.retrieveUser(request);
			
			if( user == null ) {
				return new ResponseEntity<Object>("Não Autorizado!", HttpStatus.UNAUTHORIZED);
			}

			postService.deletePost(user, postId);
			
			return  new ResponseEntity<Object>( "Post removido com sucesso!", HttpStatus.OK);
		
		} catch (Exception e) {
			return new ResponseEntity<Object>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
