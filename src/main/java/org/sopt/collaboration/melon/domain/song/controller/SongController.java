package org.sopt.collaboration.melon.domain.song.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.domain.artist.entity.Artist;
import org.sopt.collaboration.melon.domain.like.code.LikeSuccessCode;
import org.sopt.collaboration.melon.domain.like.controller.dto.response.LikeResponse;
import org.sopt.collaboration.melon.domain.like.service.LikeService;
import org.sopt.collaboration.melon.domain.song.code.SongSuccessCode;
import org.sopt.collaboration.melon.domain.song.controller.dto.response.SongDetailResponse;
import org.sopt.collaboration.melon.domain.song.service.SongArtistService;
import org.sopt.collaboration.melon.domain.song.service.SongService;
import org.sopt.collaboration.melon.domain.song.service.vo.SongWithDetail;
import org.sopt.collaboration.melon.domain.user.service.UserValidator;
import org.sopt.collaboration.melon.global.dto.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/songs")
@RequiredArgsConstructor
public class SongController implements SongApi {

    private final SongService songService;
    private final SongArtistService songArtistService;
    private final LikeService likeService;
    private final UserValidator userValidator;

    @GetMapping("/{songId}")
    public CommonResponse<SongDetailResponse> getSongDetail(
            @RequestHeader("User-Id") Long userId,
            @PathVariable Long songId
    ) {
        userValidator.validate(userId);

        SongWithDetail song = songService.readWithDetail(songId);
        List<Artist> artists = songArtistService.findAllArtistsBySongId(songId);
        boolean isLiked = likeService.isLiked(userId, songId);

        return CommonResponse.success(SongSuccessCode.SONG_FOUND, SongDetailResponse.of(song, artists, isLiked));
    }

    @PostMapping("/{songId}/like")
    public CommonResponse<LikeResponse> putLiked(
            @RequestHeader("User-Id") Long userId,
            @PathVariable Long songId
    ) {
        userValidator.validate(userId);

        boolean IsLiked = likeService.toggleLike(userId, songId);
        return CommonResponse.success(
                IsLiked ? LikeSuccessCode.LIKE_TOGGLE_SUCCEED : LikeSuccessCode.LIKE_TOGGLE_CANCELED,
                LikeResponse.from(IsLiked)
        );
    }
}
