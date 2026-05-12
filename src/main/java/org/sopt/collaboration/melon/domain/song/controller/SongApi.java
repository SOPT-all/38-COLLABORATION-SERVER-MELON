package org.sopt.collaboration.melon.domain.song.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.sopt.collaboration.melon.domain.song.controller.dto.response.SongDetailResponse;
import org.sopt.collaboration.melon.domain.song.exception.SongDetailNotFoundException;
import org.sopt.collaboration.melon.domain.song.exception.SongNotFoundException;
import org.sopt.collaboration.melon.domain.user.exception.UserNotFoundException;
import org.sopt.collaboration.melon.global.dto.CommonResponse;
import org.sopt.collaboration.melon.global.swagger.ApiExceptions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@Tag(name = "Song", description = "곡(노래) API")
public interface SongApi {

    @ApiExceptions({UserNotFoundException.class, SongNotFoundException.class, SongDetailNotFoundException.class})
    @Operation(summary = "곡 상세 조회", description = "곡 상세 정보를 조회합니다.")
    CommonResponse<SongDetailResponse> getSongDetail(
            @RequestHeader("User-Id") Long userId,
            @PathVariable Long songId
    );
}
