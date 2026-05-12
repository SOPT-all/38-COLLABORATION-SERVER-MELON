package org.sopt.collaboration.melon.domain.song.service.vo;

import org.sopt.collaboration.melon.domain.song.entity.Song;
import org.sopt.collaboration.melon.domain.song.entity.SongDetail;

public record SongWithDetail(
        Song song,
        SongDetail detail
) {

    public static SongWithDetail of(Song song, SongDetail detail) {
        return new SongWithDetail(song, detail);
    }
}
