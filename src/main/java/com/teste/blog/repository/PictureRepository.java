package com.teste.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.blog.model.Picture;

public interface PictureRepository extends JpaRepository<Picture, Long> {


}
