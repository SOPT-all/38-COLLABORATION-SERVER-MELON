package org.sopt.collaboration.melon.domain.chart.exception;

import org.sopt.collaboration.melon.domain.chart.code.ChartErrorCode;
import org.sopt.collaboration.melon.global.exception.BusinessException;

public class InvalidChartFilterException extends BusinessException {

    public InvalidChartFilterException() {
        super(ChartErrorCode.INVALID_CHART_FILTER);
    }
}
