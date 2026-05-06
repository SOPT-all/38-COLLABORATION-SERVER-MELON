package org.sopt.collaboration.melon.domain.mock.exception;

import org.sopt.collaboration.melon.domain.mock.code.MockErrorCode;
import org.sopt.collaboration.melon.global.exception.BusinessException;

public class InvalidRoleException extends BusinessException {
    public InvalidRoleException() {
        super(MockErrorCode.INVALID_ROLE);
    }
}
