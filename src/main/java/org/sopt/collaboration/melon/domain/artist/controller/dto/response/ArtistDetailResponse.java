package org.sopt.collaboration.melon.domain.artist.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Arrays;
import java.util.List;
import org.sopt.collaboration.melon.domain.album.entity.Album;
import org.sopt.collaboration.melon.domain.artist.entity.Artist;
import org.sopt.collaboration.melon.domain.artist.entity.ArtistDetail;
import org.sopt.collaboration.melon.domain.artist.entity.ArtistType;
import org.sopt.collaboration.melon.domain.artist.service.vo.ArtistWithDetail;

public record ArtistDetailResponse(
        @Schema(description = "아티스트 ID", example = "1")
        Long artistId,
        @Schema(description = "아티스트 이름", example = "Hearts2Hearts (하츠투하츠)")
        String name,
        @Schema(description = "팬 수", example = "12345")
        int fanCount,
        @Schema(description = "한줄평 수", example = "678")
        int commentCount,
        @Schema(description = "활동 연차", example = "2")
        int activeDegree,
        @Schema(description = "아티스트 이미지 URL", example = "https://static.melon.com/artist_image.png")
        String imageUrl,
        @Schema(description = "아티스트 유형 (SOLO/GROUP)", example = "GROUP")
        ArtistType type,
        @Schema(description = "그룹 구성원 목록 (SOLO인 경우 빈 배열)")
        List<ArtistMemberInfo> artists,
        @Schema(description = "최근 앨범 목록")
        List<AlbumInfo> recentAlbums,
        @Schema(description = "크레딧", example = "발매곡 69")
        String credit,
        @Schema(description = "국가", example = "대한민국")
        String country,
        @Schema(description = "소속사", example = "어트랙트")
        String agency,
        @Schema(description = "수상 이력 목록")
        List<String> awardHistory,
        @Schema(description = "아티스트 소개", example = "Hearts2Hearts는 2025년 데뷔한 8인조 걸그룹입니다.")
        String description
) {

    public static ArtistDetailResponse of(ArtistWithDetail artistWithDetail, List<Artist> groupMembers, List<Album> recentAlbums) {
        Artist artist = artistWithDetail.artist();
        ArtistDetail detail = artistWithDetail.detail();

        return new ArtistDetailResponse(
                artist.getId(),
                artist.getName(),
                detail.getFanCount(),
                detail.getCommentCount(),
                detail.getActiveDegree(),
                artist.getImageUrl(),
                artist.getType(),
                groupMembers.stream().map(ArtistMemberInfo::new).toList(),
                recentAlbums.stream().map(AlbumInfo::new).toList(),
                detail.getCredit(),
                detail.getCountry(),
                detail.getAgency(),
                Arrays.asList(detail.getAwardHistory().split("\\|")),
                detail.getDescription()
        );
    }

    record ArtistMemberInfo(
            @Schema(description = "아티스트 ID", example = "1")
            Long artistId,
            @Schema(description = "아티스트 이름", example = "주연")
            String name,
            @Schema(description = "아티스트 이미지 URL", example = "https://static.melon.com/artist_image.png")
            String imageUrl
    ) {

        public ArtistMemberInfo(Artist artist) {
            this(artist.getId(), artist.getName(), artist.getImageUrl());
        }
    }

    record AlbumInfo(
            @Schema(description = "앨범 ID", example = "1")
            Long albumId,
            @Schema(description = "앨범 제목", example = "RUDE! (Japanese Ver.)")
            String title,
            @Schema(description = "앨범 커버 이미지 URL", example = "https://static.melon.com/album_cover.png")
            String imageUrl
    ) {

        public AlbumInfo(Album album) {
            this(album.getId(), album.getTitle(), album.getImageUrl());
        }
    }
}
