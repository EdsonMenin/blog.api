package com.teste.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.blog.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {


}
