package org.sopt.collaboration.melon.domain.mock.repository;

import org.sopt.collaboration.melon.domain.mock.entity.Mock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MockRepository extends JpaRepository<Mock, Long> {
}
