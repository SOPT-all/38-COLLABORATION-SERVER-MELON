package org.sopt.collaboration.melon.domain.album.repository;

import org.sopt.collaboration.melon.domain.album.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {

}
