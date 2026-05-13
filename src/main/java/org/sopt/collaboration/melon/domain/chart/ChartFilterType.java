package org.sopt.collaboration.melon.domain.chart;

import org.sopt.collaboration.melon.domain.chart.exception.InvalidChartFilterException;

public enum ChartFilterType {
    TOP100,
    HOT100,
    ABROAD_2006, //해외 2006
    SWEET; //달달한

    public static ChartFilterType from(String chartFilterType) {
        try {
            return ChartFilterType.valueOf(chartFilterType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidChartFilterException();
        }
    }
}
