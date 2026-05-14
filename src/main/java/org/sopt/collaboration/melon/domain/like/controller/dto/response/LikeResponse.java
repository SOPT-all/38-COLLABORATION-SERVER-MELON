package org.sopt.collaboration.melon.domain.like.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;


public record LikeResponse(
        @Schema(description = "좋아요 토글", example = "true")
        Boolean isLiked
) {

    public static LikeResponse from(boolean isLiked) {
        return new LikeResponse(isLiked);
    }
}
