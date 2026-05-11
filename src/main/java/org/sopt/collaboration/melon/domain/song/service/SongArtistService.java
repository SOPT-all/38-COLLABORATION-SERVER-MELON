package org.sopt.collaboration.melon.domain.song.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.domain.artist.entity.Artist;
import org.sopt.collaboration.melon.domain.song.entity.SongArtist;
import org.sopt.collaboration.melon.domain.song.repository.SongArtistRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SongArtistService {

    private final SongArtistRepository songArtistRepository;

    public List<Artist> findAllArtistsBySongId(Long songId) {
        return songArtistRepository.findAllBySongId(songId)
                .stream()
                .map(SongArtist::getArtist)
                .toList();
    }
}
