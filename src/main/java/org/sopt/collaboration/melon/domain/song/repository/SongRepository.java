package org.sopt.collaboration.melon.domain.song.repository;

import org.sopt.collaboration.melon.domain.song.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {

}
