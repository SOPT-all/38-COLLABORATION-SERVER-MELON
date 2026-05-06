package org.sopt.collaboration.melon.global.dto;

public record IdResponse(
        Long id
) {

    public static IdResponse of(Long id) {
        return new IdResponse(id);
    }
}
