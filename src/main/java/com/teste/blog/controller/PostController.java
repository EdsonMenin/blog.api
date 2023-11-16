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

import com.teste.blog.controller.dto.CommentDto;
import com.teste.blog.controller.dto.PostDto;
import com.teste.blog.controller.resp.CommentResp;
import com.teste.blog.controller.resp.PostResp;
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
	
	@GetMapping("/lastPosts")
	public ResponseEntity<Object> lastPosts( @RequestHeader(defaultValue = "0") int page,
											 @RequestHeader(defaultValue = "10") int size) {
	    try {
	    	
	        Pageable pageable = PageRequest.of(page, size);
	        Page<PostResp> postsPage = postService.lastPosts(pageable);

	        return new ResponseEntity<>(postsPage, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
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
	
	@GetMapping("/lastCommentsForPost")
	public ResponseEntity<Object> lastCommentsForPost( @RequestHeader Long postId,
											 		   @RequestHeader(defaultValue = "0") int page,
											 		   @RequestHeader(defaultValue = "10") int size) {
	    try {
	    	
	        Pageable pageable = PageRequest.of(page, size);
	        Page<CommentResp> postsPage = postService.lastCommentsForPost(pageable, postId);

	        return new ResponseEntity<>(postsPage, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PostMapping("/createComment")
	public ResponseEntity<Object> createComment( @RequestBody CommentDto dto ) {
		
		try {
			
			Users user = userService.retrieveUser(request);
			
			if( user == null ) {
				return new ResponseEntity<Object>("Não Autorizado!", HttpStatus.UNAUTHORIZED);
			}

			postService.createComment(user, dto);
			
			return  new ResponseEntity<Object>( "Comentário cadastrado com sucesso!", HttpStatus.OK);
		
		} catch (Exception e) {
			return new ResponseEntity<Object>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteComment")
	public ResponseEntity<Object> deleteComment( @RequestHeader Long commentId ) {
		
		try {
			
			Users user = userService.retrieveUser(request);
			
			if( user == null ) {
				return new ResponseEntity<Object>("Não Autorizado!", HttpStatus.UNAUTHORIZED);
			}

			postService.deleteComment(user, commentId);
			
			return  new ResponseEntity<Object>( "Comentário removido com sucesso!", HttpStatus.OK);
		
		} catch (Exception e) {
			return new ResponseEntity<Object>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
