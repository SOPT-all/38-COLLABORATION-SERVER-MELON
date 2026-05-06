package org.sopt.collaboration.melon.domain.mock.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.sopt.collaboration.melon.domain.mock.controller.dto.request.CreateMockRequest;
import org.sopt.collaboration.melon.domain.mock.exception.InvalidMockException;
import org.sopt.collaboration.melon.domain.mock.exception.InvalidRoleException;
import org.sopt.collaboration.melon.global.dto.CommonResponse;
import org.sopt.collaboration.melon.global.dto.IdResponse;
import org.sopt.collaboration.melon.global.swagger.ApiExceptions;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Mock", description = "임시 데이터")
public interface MockApi {

    @ApiExceptions({InvalidMockException.class, InvalidRoleException.class}) //이게 내가 만든 거
    @Operation(summary = "임시 데이터 생성", description = "임시 데이터를 생성합니다.")
    CommonResponse<IdResponse> createMock(@RequestBody CreateMockRequest request);
}
