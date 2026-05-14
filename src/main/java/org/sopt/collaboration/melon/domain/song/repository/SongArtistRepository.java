package org.sopt.collaboration.melon.domain.song.repository;

import java.util.List;
import org.sopt.collaboration.melon.domain.song.entity.SongArtist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SongArtistRepository extends JpaRepository<SongArtist, Long> {

    @Query("select sa from SongArtist sa join fetch sa.artist where sa.song.id = :songId")
    List<SongArtist> findAllBySongId(Long songId);

    @Query("select sa from SongArtist sa join fetch sa.artist where sa.song.id in :songId")
    List<SongArtist> findAllBySongIdIn(List<Long> songId);

}
