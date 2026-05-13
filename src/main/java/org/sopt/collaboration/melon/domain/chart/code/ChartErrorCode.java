package org.sopt.collaboration.melon.domain.chart.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.sopt.collaboration.melon.global.code.ErrorCode;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ChartErrorCode implements ErrorCode {
    INVALID_CHART_FILTER(HttpStatus.BAD_REQUEST, "필터 값이 올바르지 않습니다.");

    private final HttpStatus status;
    private final String message;
}
