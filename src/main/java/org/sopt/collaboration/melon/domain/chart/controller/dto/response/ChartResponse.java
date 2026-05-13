package org.sopt.collaboration.melon.domain.chart.controller.dto.response;


import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import org.sopt.collaboration.melon.domain.chart.service.vo.ChartSongInfo;

public record ChartResponse(
        @Schema(description = "차트 곡 목록")
        List<SongInfo> songs
) {
    public static ChartResponse of(List<ChartSongInfo> chartSongInfos) {
        return new ChartResponse(
                chartSongInfos.stream()
                        .map(song -> new SongInfo(
                                song.songId(),
                                song.title(),
                                new ArtistInfo(
                                        song.artistId(),
                                        song.artistName()
                                ),
                                song.albumImageUrl()
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
    }

    public record ArtistInfo(
            @Schema(description = "아티스트 ID", example = "1")
            Long artistId,

            @Schema(description = "아티스트명", example = "AKMU (악뮤)")
            String name
    ) {

    }
}

