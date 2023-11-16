package com.teste.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.blog.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {


}
