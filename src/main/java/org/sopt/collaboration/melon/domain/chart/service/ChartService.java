package org.sopt.collaboration.melon.domain.chart.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.domain.chart.ChartFilterType;
import org.sopt.collaboration.melon.domain.song.entity.Song;
import org.sopt.collaboration.melon.domain.song.repository.SongDetailRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChartService {

    private final SongDetailRepository songDetailRepository;

    public List<Song> findChartSongByFilter(final ChartFilterType chartFilterType) {
        return switch (chartFilterType) {
            case TOP100 -> songDetailRepository.findTop100Chart();
            case HOT100 -> songDetailRepository.findHot100Chart();
            case ABROAD_2006, SWEET -> songDetailRepository.readChart();
        };
    }


}
