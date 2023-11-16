package com.teste.blog.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teste.blog.model.Picture;

public interface PictureRepository extends JpaRepository<Picture, Long> {

	Page<Picture> findByAlbumId(Long albumId, Pageable pageable);

	@Query( value="select p.* from picture p where p.user_id = :id and p.id = :pictureId ", nativeQuery = true)
	Picture findByUserAndId(Long id, Long pictureId);

	List<Picture> findByAlbumId(Long albumId);

}
