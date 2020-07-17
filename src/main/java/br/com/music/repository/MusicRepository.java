package br.com.music.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import br.com.music.model.Music;

public interface MusicRepository extends JpaRepository<Music, Long>{
	List<Music> findByAlbumId(@Param("id") Long id);

    @RestResource(path = "titleStartsWith", rel = "titleStartsWith")
    List<Music> findByTitleStartsWith(@Param("title") String title);
}
