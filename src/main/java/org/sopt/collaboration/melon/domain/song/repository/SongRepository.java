package org.sopt.collaboration.melon.domain.song.repository;

import org.sopt.collaboration.melon.domain.song.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SongRepository extends JpaRepository<Song, Long> {

    @Query("select s from Song s join fetch s.album")
    Song findWithAlbum(Long songId);
}
