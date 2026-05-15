package org.sopt.collaboration.melon.domain.artist.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import org.sopt.collaboration.melon.domain.artist.entity.Artist;
import org.sopt.collaboration.melon.domain.song.entity.Song;

public record ArtistSongResponse(
        @Schema(description = "아티스트의 곡 목록")
        List<ArtistSongInfo> artistSong
) {
    public static ArtistSongResponse of(List<Song> artistSong, Artist artist) {
        ArtistInfo artistInfo = ArtistInfo.of(artist);
        return new ArtistSongResponse(
                artistSong.stream()
                        .map(song -> ArtistSongInfo.of(song, artistInfo)).toList()
        );
    }

    public record ArtistSongInfo(
            @Schema(description = "곡 ID", example = "1")
            Long songId,

            @Schema(description = "곡 제목", example = "RUDE!")
            String title,

            @Schema(description = "아티스트 정보")
            ArtistInfo artist,

            @Schema(description = "앨범 이미지 URL", example = "https://static.melon.com/album-cover.png")
            String albumImageUrl

    ) {
        public static ArtistSongInfo of(Song song, ArtistInfo artist) {
            return new ArtistSongInfo(
                    song.getId(),
                    song.getTitle(),
                    artist,
                    song.getAlbum().getImageUrl()
            );
        }

    }

    public record ArtistInfo(
            @Schema(description = "아티스트 ID", example = "1")
            Long artistId,

            @Schema(description = "아티스트 이름", example = "Hearts2Hearts (하츠투하츠)")
            String name

    ) {
        public static ArtistInfo of(Artist artist) {
            return new ArtistInfo(
                    artist.getId(),
                    artist.getName()
            );
        }
    }
}
