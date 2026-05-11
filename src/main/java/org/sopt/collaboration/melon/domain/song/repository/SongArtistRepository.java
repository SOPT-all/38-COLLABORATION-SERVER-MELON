package org.sopt.collaboration.melon.domain.song.repository;

import java.util.List;
import org.sopt.collaboration.melon.domain.song.entity.SongArtist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongArtistRepository extends JpaRepository<SongArtist, Long> {

    List<SongArtist> findAllBySongId(Long songId);
}
