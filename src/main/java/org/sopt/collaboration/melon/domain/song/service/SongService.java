package org.sopt.collaboration.melon.domain.song.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.domain.artist.entity.ArtistSongSortFilter;
import org.sopt.collaboration.melon.domain.song.entity.Song;
import org.sopt.collaboration.melon.domain.song.entity.SongDetail;
import org.sopt.collaboration.melon.domain.song.exception.SongNotFoundException;
import org.sopt.collaboration.melon.domain.song.repository.SongDetailRepository;
import org.sopt.collaboration.melon.domain.song.repository.SongRepository;
import org.sopt.collaboration.melon.domain.song.service.vo.SongWithDetail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SongService {

    private final SongRepository songRepository;
    private final SongDetailRepository songDetailRepository;

    public SongWithDetail readWithDetail(Long songId) {
        Song song = songRepository.findWithAlbum(songId)
                .orElseThrow(SongNotFoundException::new);

        SongDetail detail = readDetailOrThrow(songId);

        return SongWithDetail.of(song, detail);
    }

    private SongDetail readDetailOrThrow(Long songId) {
        return songDetailRepository.findById(songId)
                .orElseThrow(SongNotFoundException::new);
    }

    public List<Song> findSongBySortFilter(ArtistSongSortFilter sortFilter) {
        return switch (sortFilter) {
            case HOT -> songDetailRepository.findHotSongs();
            case LATEST -> songRepository.findLatestSongs();
            case DOWNLOAD -> songRepository.findDownloadSongs();
            case PLAY -> songDetailRepository.findTopSongs();
        };
    }
}
