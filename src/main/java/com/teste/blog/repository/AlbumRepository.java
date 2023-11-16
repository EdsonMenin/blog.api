package com.teste.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teste.blog.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

	@Query( value="select a.* from album a where a.user_id = :id and a.id = :albumId ", nativeQuery = true)
	Album findByUserAndId(Long id, Long albumId);

}
