package org.sopt.collaboration.melon.domain.artist.entity;

import org.sopt.collaboration.melon.domain.artist.exception.InvalidSortFilterException;

public enum ArtistSongSortFilter {
    HOT,
    LATEST,
    DOWNLOAD,
    PLAY;

    public static ArtistSongSortFilter from(String sortFilter) {
        try {
            return ArtistSongSortFilter.valueOf(sortFilter.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidSortFilterException();
        }
    }
}
