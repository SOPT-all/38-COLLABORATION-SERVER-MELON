package org.sopt.collaboration.melon.domain.artist.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.global.code.SuccessCode;


@Getter
@RequiredArgsConstructor
public enum ArtistSongListSuccessCode implements SuccessCode {
    ARTIST_SONG_LIST_FOUND("아티스트의 곡 목록을 조회했어요.");

    private final String message;
}