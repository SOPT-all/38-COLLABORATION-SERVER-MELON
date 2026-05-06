package org.sopt.collaboration.melon.domain.mock.exception;

import org.sopt.collaboration.melon.domain.mock.code.MockErrorCode;
import org.sopt.collaboration.melon.global.exception.BusinessException;

public class InvalidMockException extends BusinessException {
    public InvalidMockException() {
        super(MockErrorCode.INVALID_INPUT);
    }
}
