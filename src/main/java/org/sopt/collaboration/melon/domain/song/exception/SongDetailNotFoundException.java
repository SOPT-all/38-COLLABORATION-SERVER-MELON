package org.sopt.collaboration.melon.domain.song.exception;

import org.sopt.collaboration.melon.domain.song.code.SongErrorCode;
import org.sopt.collaboration.melon.global.exception.BusinessException;

public class SongDetailNotFoundException extends BusinessException {

    public SongDetailNotFoundException() {
        super(SongErrorCode.SONG_DETAIL_NOT_FOUND);
    }
}
