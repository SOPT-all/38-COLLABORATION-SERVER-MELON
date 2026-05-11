package org.sopt.collaboration.melon.domain.song.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.global.code.SuccessCode;

@Getter
@RequiredArgsConstructor
public enum SongSuccessCode implements SuccessCode {
    SONG_FOUND("곡 정보를 조회했어요.");

    private final String message;
}
