package org.sopt.collaboration.melon.domain.mock.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.global.code.ErrorCode;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MockErrorCode implements ErrorCode {
    INVALID_INPUT(HttpStatus.BAD_REQUEST, "입력값오류"), INVALID_ROLE(HttpStatus.FORBIDDEN, "참여 불가능한 역할입니다.");

    private final HttpStatus status;
    private final String message;
}