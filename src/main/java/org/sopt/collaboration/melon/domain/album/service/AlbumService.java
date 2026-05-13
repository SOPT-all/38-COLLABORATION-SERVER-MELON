package org.sopt.collaboration.melon.domain.album.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.domain.album.entity.Album;
import org.sopt.collaboration.melon.domain.album.entity.AlbumArtist;
import org.sopt.collaboration.melon.domain.album.repository.AlbumArtistRepository;
import org.sopt.collaboration.melon.domain.artist.entity.Artist;
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

    public Map<Long, List<Artist>> findArtistsAsMap(List<Album> albums) {
        List<Long> albumIds = albums.stream()
                .map(Album::getId)
                .toList();

        return albumArtistRepository.findAllByAlbumIdIn(albumIds).stream()
                .collect(Collectors.groupingBy(
                        AlbumArtist::getAlbumId,
                        Collectors.mapping(AlbumArtist::getArtist, Collectors.toList())
                ));
    }
}
