package org.sopt.collaboration.melon.domain.artist.service.vo;

import org.sopt.collaboration.melon.domain.artist.entity.Artist;
import org.sopt.collaboration.melon.domain.artist.entity.ArtistDetail;

public record ArtistWithDetail(
        Artist artist,
        ArtistDetail detail
) {

    public static ArtistWithDetail of(Artist artist, ArtistDetail detail) {
        return new ArtistWithDetail(artist, detail);
    }
}
