package org.sopt.collaboration.melon.domain.like.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.sopt.collaboration.melon.domain.like.entity.Like;
import org.sopt.collaboration.melon.domain.like.repository.LikeRepository;
import org.sopt.collaboration.melon.domain.song.entity.SongDetail;
import org.sopt.collaboration.melon.domain.song.exception.SongNotFoundException;
import org.sopt.collaboration.melon.domain.song.repository.SongDetailRepository;
import org.sopt.collaboration.melon.domain.user.service.UserValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserValidator userValidator;
    private final SongDetailRepository songDetailRepository;

    public boolean isLiked(Long userId, Long songId) {

        return likeRepository.existsByUserIdAndSongId(userId, songId);

    }

    @Transactional
    public boolean toggleLike(Long userId, Long songId) {
        userValidator.validate(userId);
        SongDetail songDetail = songDetailRepository.findBySongIdWithLock(songId)
                .orElseThrow(SongNotFoundException::new);
        Optional<Like> existingLike = likeRepository.findByUserIdAndSongId(userId, songId);

        if (existingLike.isPresent()) {
            likeRepository.delete(existingLike.get());
            songDetail.decreaseLikeCount();
            return false;
        } else {
            likeRepository.save(Like.create(userId, songId));
            songDetail.increaseLikeCount();
            return true;
        }

    }

}
