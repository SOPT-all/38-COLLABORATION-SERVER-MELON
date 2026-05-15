package org.sopt.collaboration.melon.domain.artist.exception;

import org.sopt.collaboration.melon.domain.artist.code.ArtistSongListErrorCode;
import org.sopt.collaboration.melon.global.exception.BusinessException;

public class InvalidSortFilterException extends BusinessException {

    public InvalidSortFilterException() {
        super(ArtistSongListErrorCode.INVALID_SORT_FILTER);
    }
}
