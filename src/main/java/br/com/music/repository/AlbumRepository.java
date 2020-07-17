package br.com.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.music.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>{

}
