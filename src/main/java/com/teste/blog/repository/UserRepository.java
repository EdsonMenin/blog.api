package com.teste.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.blog.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByUsername(String username);

}
