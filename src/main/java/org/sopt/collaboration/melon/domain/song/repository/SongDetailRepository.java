package org.sopt.collaboration.melon.domain.song.repository;

import java.util.List;
import org.sopt.collaboration.melon.domain.chart.service.vo.ChartSongInfo;
import org.sopt.collaboration.melon.domain.song.entity.SongDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SongDetailRepository extends JpaRepository<SongDetail, Long> {

    @Query("""
            select new org.sopt.collaboration.melon.domain.chart.service.vo.ChartSongInfo(
                s.id,
                s.title,
                a.id,
                a.name,
                al.imageUrl
            )
            from SongDetail sd
            join sd.song s
            join s.album al
            join SongArtist sa on sa.songId = s.id
            join sa.artist a
            order by sd.playCount desc
            """)
    List<ChartSongInfo> findTop100Chart();

    @Query("""
            select new org.sopt.collaboration.melon.domain.chart.service.vo.ChartSongInfo(
                s.id,
                s.title,
                a.id,
                a.name,
                al.imageUrl
            )
            from SongDetail sd
            join sd.song s
            join s.album al
            join SongArtist sa on sa.songId = s.id
            join sa.artist a
            join ArtistDetail ad on ad.artistId = a.id
            order by sd.likeCount + ad.fanCount desc
            """)
    List<ChartSongInfo> findHot100Chart();

    @Query("""
            select new org.sopt.collaboration.melon.domain.chart.service.vo.ChartSongInfo(
                s.id,
                s.title,
                a.id,
                a.name,
                al.imageUrl
            )
            from SongDetail sd
            join sd.song s
            join s.album al
            join SongArtist sa on sa.songId = s.id
            join sa.artist a
            """)
    List<ChartSongInfo> readChart();

}
