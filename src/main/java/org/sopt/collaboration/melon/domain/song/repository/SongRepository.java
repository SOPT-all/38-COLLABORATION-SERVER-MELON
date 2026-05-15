package org.sopt.collaboration.melon.domain.song.repository;

import java.util.List;
import java.util.Optional;
import org.sopt.collaboration.melon.domain.song.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SongRepository extends JpaRepository<Song, Long> {

    @Query("select s from Song s join fetch s.album where s.id = :songId")
    Optional<Song> findWithAlbum(Long songId);

    @Query("select s from Song s join fetch s.album order by s.createdAt DESC ")
    List<Song> findLatestSongs();

    @Query("select s from Song s join fetch s.album")
    List<Song> findDownloadSongs();

}
