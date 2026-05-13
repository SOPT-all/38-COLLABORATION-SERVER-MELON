package org.sopt.collaboration.melon.domain.album.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.domain.album.entity.Album;
import org.sopt.collaboration.melon.domain.album.entity.AlbumArtist;
import org.sopt.collaboration.melon.domain.album.repository.AlbumArtistRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AlbumService {

    private final AlbumArtistRepository albumArtistRepository;

    public List<Album> findAllByArtistId(Long artistId) {
        List<AlbumArtist> albumArtists = albumArtistRepository.findAllByArtistId(artistId);

        return albumArtists.stream()
                .map(AlbumArtist::getAlbum)
                .toList();
    }
}
