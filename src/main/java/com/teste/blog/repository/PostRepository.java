package com.teste.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teste.blog.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	@Query( value="select p.* from post p where p.user_id = :user and p.id = :postId ", nativeQuery = true)
	Post findByUserAndId(Long user, Long postId);


}
