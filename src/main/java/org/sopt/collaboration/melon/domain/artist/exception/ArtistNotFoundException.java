package org.sopt.collaboration.melon.domain.artist.exception;

import org.sopt.collaboration.melon.domain.artist.code.ArtistErrorCode;
import org.sopt.collaboration.melon.global.exception.BusinessException;

public class ArtistNotFoundException extends BusinessException {

    public ArtistNotFoundException() {
        super(ArtistErrorCode.ARTIST_NOT_FOUND);
    }
}
