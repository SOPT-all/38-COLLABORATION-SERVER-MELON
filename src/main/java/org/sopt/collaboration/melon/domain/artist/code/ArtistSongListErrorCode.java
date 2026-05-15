package org.sopt.collaboration.melon.domain.artist.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.global.code.ErrorCode;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ArtistSongListErrorCode implements ErrorCode {
    INVALID_SORT_FILTER(HttpStatus.BAD_REQUEST, "필터 값이 올바르지 않습니다.");

    private final HttpStatus status;
    private final String message;
}
