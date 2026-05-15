package org.sopt.collaboration.melon.domain.artist.repository;

import java.util.List;
import org.sopt.collaboration.melon.domain.artist.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    List<Artist> findAllByGroupId(Long groupId);

}
