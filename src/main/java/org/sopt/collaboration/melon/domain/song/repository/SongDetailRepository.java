package org.sopt.collaboration.melon.domain.song.repository;


import jakarta.persistence.LockModeType;
import java.util.List;
import java.util.Optional;
import org.sopt.collaboration.melon.domain.song.entity.Song;
import org.sopt.collaboration.melon.domain.song.entity.SongDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

public interface SongDetailRepository extends JpaRepository<SongDetail, Long> {

    @Query("""
                select s
                from SongDetail sd
                join sd.song s
                join fetch s.album
                order by sd.playCount desc
            """)
    List<Song> findTop100Chart();

    @Query("""
                select s
                from SongDetail sd
                join sd.song s
                join fetch s.album
                join SongArtist sa on sa.song.id = s.id
                join sa.artist a
                join ArtistDetail ad on ad.artist.id = a.id
                group by s.id, s.title, s.playTime, s.album, s.createdAt, s.updatedAt, sd.likeCount
                order by (sd.likeCount + coalesce(sum(ad.fanCount), 0)) desc
            """)
    List<Song> findHot100Chart();

    @Query("""
                select s
                from SongDetail sd
                join sd.song s
                join fetch s.album
            """)
    List<Song> readChart();

    @Lock(LockModeType.OPTIMISTIC)
    @Query("""
                select sd
                from SongDetail sd
                where sd.id = :songId
            """)
    Optional<SongDetail> findBySongIdWithLock(Long songId);
}
