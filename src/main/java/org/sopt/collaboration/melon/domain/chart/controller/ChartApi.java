package org.sopt.collaboration.melon.domain.chart.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.sopt.collaboration.melon.domain.chart.controller.dto.response.ChartResponse;
import org.sopt.collaboration.melon.domain.chart.exception.InvalidChartFilterException;
import org.sopt.collaboration.melon.global.dto.CommonResponse;
import org.sopt.collaboration.melon.global.swagger.ApiExceptions;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Chart", description = "차트 API")
public interface ChartApi {

    @ApiExceptions(InvalidChartFilterException.class)
    @Operation(summary = "차트 조회", description = "필터에 따라 차트를 조회합니다.")
    CommonResponse<ChartResponse> getChartByFilter(@RequestParam String chartFilter);
}
