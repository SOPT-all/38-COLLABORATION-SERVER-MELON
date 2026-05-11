package org.sopt.collaboration.melon.domain.song.exception;

import org.sopt.collaboration.melon.domain.song.code.SongErrorCode;
import org.sopt.collaboration.melon.global.exception.BusinessException;

public class SongNotFoundException extends BusinessException {

    public SongNotFoundException() {
        super(SongErrorCode.SONG_NOT_FOUND);
    }
}
