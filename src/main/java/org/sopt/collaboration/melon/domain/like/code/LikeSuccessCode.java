package org.sopt.collaboration.melon.domain.like.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.global.code.SuccessCode;

@Getter
@RequiredArgsConstructor
public enum LikeSuccessCode implements SuccessCode {
    LIKE_TOGGLE_SUCCEED("좋아요를 눌렀어요."),
    LIKE_TOGGLE_CANCELED("좋아요를 취소했어요."),
    ;

    private final String message;
}
