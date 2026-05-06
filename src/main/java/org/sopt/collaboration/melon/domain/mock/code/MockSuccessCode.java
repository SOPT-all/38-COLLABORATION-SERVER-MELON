package org.sopt.collaboration.melon.domain.mock.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.global.code.SuccessCode;

@Getter
@RequiredArgsConstructor
public enum MockSuccessCode implements SuccessCode {
    CREATED("성공");

    private final String message;
}
