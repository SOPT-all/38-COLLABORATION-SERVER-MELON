package org.sopt.collaboration.melon.domain.chart.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.global.code.SuccessCode;

@Getter
@RequiredArgsConstructor
public enum ChartSuccessCode implements SuccessCode {
    GET_CHART("실시간 차트를 조회했어요."),
    ;

    private final String message;
}
