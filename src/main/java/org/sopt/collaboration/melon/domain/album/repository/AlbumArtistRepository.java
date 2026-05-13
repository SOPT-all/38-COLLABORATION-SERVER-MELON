package org.sopt.collaboration.melon.domain.album.repository;

import java.util.List;
import org.sopt.collaboration.melon.domain.album.entity.AlbumArtist;
import org.sopt.collaboration.melon.domain.artist.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlbumArtistRepository extends JpaRepository<AlbumArtist, Long> {

    List<AlbumArtist> artist(Artist artist);

    @Query("""
        select a from AlbumArtist a
        join fetch a.album
        where a.artistId = :artistId
        order by a.album.releaseDate desc
    """)
    List<AlbumArtist> findAllByArtistId(Long artistId);
}
