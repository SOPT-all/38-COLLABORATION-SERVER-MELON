package org.sopt.collaboration.melon.global.exception;

import lombok.Getter;
import org.sopt.collaboration.melon.global.code.ErrorCode;

@Getter
public class BusinessException extends RuntimeException {

    private final ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
