package org.sopt.collaboration.melon.domain.mock.controller.dto.request;

import org.sopt.collaboration.melon.domain.mock.service.vo.CreateMockCommand;

public record CreateMockRequest(
        String title,
        String content
) {

    public CreateMockCommand toCommand() {
        return new CreateMockCommand(title, content);
    }
}
