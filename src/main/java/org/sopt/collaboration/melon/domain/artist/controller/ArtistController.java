package org.sopt.collaboration.melon.domain.artist.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.domain.album.entity.Album;
import org.sopt.collaboration.melon.domain.album.service.AlbumService;
import org.sopt.collaboration.melon.domain.artist.code.ArtistSuccessCode;
import org.sopt.collaboration.melon.domain.artist.controller.dto.response.ArtistDetailResponse;
import org.sopt.collaboration.melon.domain.artist.entity.Artist;
import org.sopt.collaboration.melon.domain.artist.service.ArtistService;
import org.sopt.collaboration.melon.domain.artist.service.vo.ArtistWithDetail;
import org.sopt.collaboration.melon.domain.user.service.UserValidator;
import org.sopt.collaboration.melon.global.dto.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/artists")
@RequiredArgsConstructor
public class ArtistController implements ArtistApi {

    private final UserValidator userValidator;
    private final ArtistService artistService;
    private final AlbumService albumService;

    @GetMapping("/{artistId}")
    public CommonResponse<ArtistDetailResponse> getArtistDetail(
            @RequestHeader("User-Id") Long userId,
            @PathVariable Long artistId
    ) {
        userValidator.validate(userId);

        ArtistWithDetail artist = artistService.readWithDetail(artistId);
        List<Album> recentAlbums = albumService.findAllByArtistId(artistId);
        Map<Long, List<Artist>> albumArtistMap = albumService.findArtistsAsMap(recentAlbums);
        List<Artist> groupMembers =
                artist.artist().isGroup() ? artistService.findAllGroupMembers(artistId) : Collections.emptyList();

        return CommonResponse.success(
                ArtistSuccessCode.ARTIST_FOUND,
                ArtistDetailResponse.of(artist, groupMembers, recentAlbums, albumArtistMap)
        );
    }
}
