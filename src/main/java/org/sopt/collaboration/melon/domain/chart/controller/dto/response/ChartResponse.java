package org.sopt.collaboration.melon.domain.chart.controller.dto.response;


import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.Map;
import org.sopt.collaboration.melon.domain.artist.entity.Artist;
import org.sopt.collaboration.melon.domain.song.entity.Song;


public record ChartResponse(
        @Schema(description = "차트 곡 목록")
        List<SongInfo> songs
) {

    public static ChartResponse of(List<Song> songs, Map<Long, List<Artist>> artistsMap) {
        return new ChartResponse(
                songs.stream()
                        .map(song -> SongInfo.of(
                                song,
                                artistsMap.getOrDefault(song.getId(), List.of())
                        ))
                        .toList()
        );
    }

    public record SongInfo(
            @Schema(description = "곡 ID", example = "1")
            Long songId,

            @Schema(description = "곡 제목", example = "소문의 낙원")
            String title,

            @Schema(description = "아티스트 정보")
            ArtistInfo artist,

            @Schema(description = "앨범 이미지 URL", example = "https://static.melon.com/album-cover.png")
            String albumImageUrl

    ) {

        public static SongInfo of(Song song, List<Artist> artists) {
            Artist artist = artists.getFirst();

            return new SongInfo(
                    song.getId(),
                    song.getTitle(),
                    new ArtistInfo(artist),
                    song.getAlbum().getImageUrl()
            );
        }
    }

    public record ArtistInfo(
            @Schema(description = "아티스트 ID", example = "1")
            Long artistId,

            @Schema(description = "아티스트명", example = "AKMU (악뮤)")
            String name
    ) {

        public ArtistInfo(Artist artist) {
            this(artist.getId(), artist.getName());
        }
    }
}

