package org.sopt.collaboration.melon.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.domain.user.exception.UserNotFoundException;
import org.sopt.collaboration.melon.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserValidator {

    private final UserRepository userRepository;

    public void validate(Long userId) {
        boolean exists = userRepository.existsById(userId);

        if (!exists) {
            throw new UserNotFoundException();
        }
    }
}
