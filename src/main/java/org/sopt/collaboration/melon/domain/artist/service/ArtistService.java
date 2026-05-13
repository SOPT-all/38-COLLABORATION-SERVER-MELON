package org.sopt.collaboration.melon.domain.artist.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.domain.artist.entity.Artist;
import org.sopt.collaboration.melon.domain.artist.entity.ArtistDetail;
import org.sopt.collaboration.melon.domain.artist.exception.ArtistNotFoundException;
import org.sopt.collaboration.melon.domain.artist.repository.ArtistDetailRepository;
import org.sopt.collaboration.melon.domain.artist.repository.ArtistRepository;
import org.sopt.collaboration.melon.domain.artist.service.vo.ArtistWithDetail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArtistService {

    private final ArtistRepository artistRepository;
    private final ArtistDetailRepository artistDetailRepository;

    public ArtistWithDetail readWithDetail(Long artistId) {
        Artist artist = readOrThrow(artistId);
        ArtistDetail detail = readDetailOrThrow(artistId);

        return ArtistWithDetail.of(artist, detail);
    }

    public List<Artist> findAllGroupMembers(Long groupId) {
        return artistRepository.findAllByGroupId(groupId);
    }

    public Artist readOrThrow(Long artistId) {
        return artistRepository.findById(artistId)
                .orElseThrow(ArtistNotFoundException::new);
    }

    public ArtistDetail readDetailOrThrow(Long artistId) {
        return artistDetailRepository.findById(artistId)
                .orElseThrow(ArtistNotFoundException::new);
    }
}
