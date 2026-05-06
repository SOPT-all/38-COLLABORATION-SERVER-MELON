package org.sopt.collaboration.melon.domain.mock.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.domain.mock.entity.Mock;
import org.sopt.collaboration.melon.domain.mock.exception.InvalidMockException;
import org.sopt.collaboration.melon.domain.mock.exception.InvalidRoleException;
import org.sopt.collaboration.melon.domain.mock.repository.MockRepository;
import org.sopt.collaboration.melon.domain.mock.service.vo.CreateMockCommand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MockService {

    private final MockRepository mockRepository;

    @Transactional //C U D 만
    public Long createMock(CreateMockCommand command) {
        //여기부터는 참고하지 말기!
        //mock 데이터 생성하는 코드
        if (command.title().isBlank() || command.content().isBlank()) {
            throw new InvalidMockException();
        }

        //들어오려는 사람의 역할이 서버가 아님
        if (command.title().length() > 100) {
            throw new InvalidRoleException();
        }

        Mock saved = mockRepository.save(
                Mock.builder()
                        .title(command.title())
                        .content(command.content())
                        .build()
        );

        return saved.getId();
    }

    public List<Mock> getMockList() {
        return List.of();
    }
}
