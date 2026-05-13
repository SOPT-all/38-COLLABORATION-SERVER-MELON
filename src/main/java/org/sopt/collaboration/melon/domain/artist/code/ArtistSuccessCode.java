package org.sopt.collaboration.melon.domain.artist.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.global.code.SuccessCode;

@Getter
@RequiredArgsConstructor
public enum ArtistSuccessCode implements SuccessCode {
    ARTIST_FOUND("아티스트 상세 정보를 조회했어요.");

    private final String message;
}
