package org.sopt.collaboration.melon.domain.chart.controller;

import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.domain.artist.entity.Artist;
import org.sopt.collaboration.melon.domain.chart.ChartFilterType;
import org.sopt.collaboration.melon.domain.chart.code.ChartSuccessCode;
import org.sopt.collaboration.melon.domain.chart.controller.dto.response.ChartResponse;
import org.sopt.collaboration.melon.domain.chart.service.ChartService;
import org.sopt.collaboration.melon.domain.song.entity.Song;
import org.sopt.collaboration.melon.domain.song.service.SongArtistService;
import org.sopt.collaboration.melon.global.dto.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/chart")
@RequiredArgsConstructor
public class ChartController implements ChartApi {

    private final ChartService chartService;
    private final SongArtistService songArtistService;

    @GetMapping
    public CommonResponse<ChartResponse> getChartByFilter(
            @RequestParam(defaultValue = "TOP100") String chartFilter
    ) {

        List<Song> chartSongsByFilter = chartService.findChartSongByFilter(ChartFilterType.from(chartFilter));

        Map<Long, List<Artist>> artistsMap = songArtistService.findArtistAsMap(chartSongsByFilter);

        ChartResponse response = ChartResponse.of(chartSongsByFilter, artistsMap);

        return CommonResponse.success(ChartSuccessCode.GET_CHART, response);
    }

}
