package org.sopt.collaboration.melon.domain.artist.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.sopt.collaboration.melon.domain.artist.controller.dto.response.ArtistDetailResponse;
import org.sopt.collaboration.melon.domain.artist.controller.dto.response.ArtistSongResponse;
import org.sopt.collaboration.melon.domain.artist.exception.ArtistNotFoundException;
import org.sopt.collaboration.melon.domain.artist.exception.InvalidSortFilterException;
import org.sopt.collaboration.melon.domain.user.exception.UserNotFoundException;
import org.sopt.collaboration.melon.global.dto.CommonResponse;
import org.sopt.collaboration.melon.global.swagger.ApiExceptions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Artist", description = "아티스트 API")
public interface ArtistApi {

    @ApiExceptions({UserNotFoundException.class, ArtistNotFoundException.class})
    @Operation(summary = "아티스트 상세 조회", description = "아티스트 상세 정보를 조회합니다.")
    CommonResponse<ArtistDetailResponse> getArtistDetail(
            @RequestHeader("User-Id") Long userId,
            @PathVariable Long artistId
    );

    @ApiExceptions({InvalidSortFilterException.class})
    @Operation(summary = "아티스트 곡 목록 조회", description = "아티스트 곡 목록을 조회합니다.")
    CommonResponse<ArtistSongResponse> getArtistSongs(
            @PathVariable Long artistId,
            @RequestParam String sort
    );
}
