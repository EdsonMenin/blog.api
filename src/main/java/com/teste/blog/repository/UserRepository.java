package com.teste.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.blog.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
