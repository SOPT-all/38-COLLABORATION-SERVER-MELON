package org.sopt.collaboration.melon.domain.like.service;

import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.domain.like.repository.LikeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LikeService {

    private final LikeRepository likeRepository;

    public boolean isLiked(Long userId, Long songId) {
        return likeRepository.existsByUserIdAndSongId(userId, songId);
    }
}
