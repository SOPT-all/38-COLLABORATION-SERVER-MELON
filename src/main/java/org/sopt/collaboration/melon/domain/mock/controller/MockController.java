package org.sopt.collaboration.melon.domain.mock.controller;

// POST /v1/mocks : mock 생성
// PUT /v1/mocks/{mockId} : mock id 기반으로 데이터 수정
// GET /v1/mocks : mock 목록 조회

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.domain.mock.code.MockSuccessCode;
import org.sopt.collaboration.melon.domain.mock.controller.dto.request.CreateMockRequest;
import org.sopt.collaboration.melon.domain.mock.service.MockService;
import org.sopt.collaboration.melon.global.dto.CommonResponse;
import org.sopt.collaboration.melon.global.dto.IdResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/mocks")
@RequiredArgsConstructor
public class MockController implements MockApi {

    private final MockService mockService;

    @PostMapping
    public CommonResponse<IdResponse> createMock(@RequestBody CreateMockRequest request) {
        Long mockId = mockService.createMock(request.toCommand());

        return CommonResponse.success(MockSuccessCode.CREATED, IdResponse.of(mockId));
    }

}
