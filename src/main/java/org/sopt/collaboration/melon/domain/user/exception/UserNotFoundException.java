package org.sopt.collaboration.melon.domain.user.exception;

import org.sopt.collaboration.melon.domain.user.code.UserErrorCode;
import org.sopt.collaboration.melon.global.exception.BusinessException;

public class UserNotFoundException extends BusinessException {

    public UserNotFoundException() {
        super(UserErrorCode.USER_NOT_FOUND);
    }
}
