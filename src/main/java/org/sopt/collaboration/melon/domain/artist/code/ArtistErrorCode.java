package org.sopt.collaboration.melon.domain.artist.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.global.code.ErrorCode;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ArtistErrorCode implements ErrorCode {
    ARTIST_NOT_FOUND(HttpStatus.NOT_FOUND, "아티스트 정보를 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String message;
}
