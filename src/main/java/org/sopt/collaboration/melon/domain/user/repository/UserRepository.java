package org.sopt.collaboration.melon.domain.user.repository;

import org.sopt.collaboration.melon.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
