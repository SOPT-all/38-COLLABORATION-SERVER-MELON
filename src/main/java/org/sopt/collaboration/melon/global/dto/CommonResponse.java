package org.sopt.collaboration.melon.global.dto;

import org.sopt.collaboration.melon.global.code.ErrorCode;
import org.sopt.collaboration.melon.global.code.GlobalErrorCode;
import org.sopt.collaboration.melon.global.code.SuccessCode;
import org.springframework.http.HttpStatus;

public record CommonResponse<T>(
        int status,
        String code,
        String message,
        T data
) {

    public static <T> CommonResponse<T> success(SuccessCode successCode, T data) {
        return new CommonResponse<>(200, successCode.name(), successCode.getMessage(), data);
    }

    public static CommonResponse<Void> success(SuccessCode successCode) {
        return success(successCode, null);
    }

    public static CommonResponse<Void> error(ErrorCode errorCode) {
        return new CommonResponse<>(errorCode.getStatus().value(), errorCode.name(), errorCode.getMessage(), null);
    }

    public static CommonResponse<Void> error(Exception e) {
        GlobalErrorCode errorMessage = GlobalErrorCode.INTERNAL_SERVER_ERROR;
        String consoleMessage = e.getClass().getSimpleName() + ": " + e.getMessage();
        return new CommonResponse<>(errorMessage.getStatus().value(), consoleMessage, errorMessage.getMessage(), null);
    }

    public static CommonResponse<Void> validationError(String validationErrorMessage) {
        return new CommonResponse<>(HttpStatus.BAD_REQUEST.value(), "VALIDATION_ERROR", validationErrorMessage, null);
    }
}