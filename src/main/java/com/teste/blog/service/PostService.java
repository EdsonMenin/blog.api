package com.teste.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.blog.controller.dto.PostDto;
import com.teste.blog.model.Post;
import com.teste.blog.model.Users;
import com.teste.blog.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	public void createPost(Users user, PostDto dto) {
		
		Post post = new Post(user, dto.getText(), dto.getImageUrl(), dto.getLinkUrl());

		postRepository.save(post);
	}

	public void deletePost(Users user, Long postId) {
		
		Post post = postRepository.findByUserAndId(user.getId(), postId);
		
		postRepository.delete(post);
	}
	

}
