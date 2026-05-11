package org.sopt.collaboration.melon.domain.song.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.global.code.ErrorCode;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SongErrorCode implements ErrorCode {
    SONG_NOT_FOUND(HttpStatus.NOT_FOUND, "곡 정보를 찾을 수 없습니다."),
    SONG_DETAIL_NOT_FOUND(HttpStatus.NOT_FOUND, "곡 상세 정보를 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String message;
}
