package org.sopt.collaboration.melon.global.code;

import org.springframework.http.HttpStatus;

public interface ErrorCode {

    String name();

    HttpStatus getStatus();

    String getMessage();
}
