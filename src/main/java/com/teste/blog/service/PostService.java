package com.teste.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.teste.blog.controller.dto.CommentDto;
import com.teste.blog.controller.dto.PostDto;
import com.teste.blog.controller.dto.PostResp;
import com.teste.blog.model.Post;
import com.teste.blog.model.Users;
import com.teste.blog.repository.CommentRepository;
import com.teste.blog.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;

	public void createPost(Users user, PostDto dto) {
		
		Post post = new Post(user, dto.getText(), dto.getImageUrl(), dto.getLinkUrl());

		postRepository.save(post);
	}

	public void deletePost(Users user, Long postId) {
		
		Post post = postRepository.findByUserAndId(user.getId(), postId);
		
		postRepository.delete(post);
	}

	public Page<PostResp> lastPosts(Pageable pageable) {
	    Page<Post> postsPage = postRepository.findAll(pageable);
	    return mapPageToPostRespPage(postsPage);
	}
	
	public Page<PostResp> mapPageToPostRespPage(Page<Post> postsPage) {
	    return postsPage.map(post -> mapToPostResp(post));
	}

	public PostResp mapToPostResp(Post post) {
		
	    PostResp postResp = new PostResp();
	    postResp.setId(post.getId());
	    postResp.setUserId(post.getUser().getId());
	    postResp.setText(post.getText());
	    postResp.setImageUrl(post.getImageUrl());
	    postResp.setLinkUrl(post.getLinkUrl());
	    return postResp;
	}

	public void createComment(Users user, CommentDto dto) {
		
		
	}

	public void deleteComment(Users user, Long commentId) {
		// TODO Auto-generated method stub
		
	}

	public Page<CommentDto> lastCommentsForPost(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
