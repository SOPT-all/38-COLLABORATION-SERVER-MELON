package org.sopt.collaboration.melon.domain.chart.service.vo;

public record ChartSongInfo(
        Long songId,
        String title,
        Long artistId,
        String artistName,
        String albumImageUrl
) {

}
