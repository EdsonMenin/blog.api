package com.teste.blog.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teste.blog.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	Page<Comment> findByPostId(Long postId, Pageable pageable);

	@Query( value="select c.* from comment c where c.user_id = :id and c.id = :commentId ", nativeQuery = true)
	Comment findByUserAndId(Long id, Long commentId);

	List<Comment> findByPostId(Long postId);

}
