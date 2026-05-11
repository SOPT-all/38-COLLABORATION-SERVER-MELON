package org.sopt.collaboration.melon.domain.song.controller.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import org.sopt.collaboration.melon.domain.album.entity.Album;
import org.sopt.collaboration.melon.domain.artist.entity.Artist;
import org.sopt.collaboration.melon.domain.song.entity.Song;
import org.sopt.collaboration.melon.domain.song.entity.SongDetail;
import org.sopt.collaboration.melon.domain.song.service.vo.SongWithDetail;

public record SongDetailResponse(
        @Schema(description = "곡 ID", example = "1")
        Long songId,
        @Schema(description = "곡 제목", example = "RUDE!")
        String title,
        @Schema(description = "참여 아티스트 목록")
        List<ArtistInfo> artists,
        @Schema(description = "앨범 정보")
        AlbumInfo album,
        @Schema(description = "좋아요 수", example = "12345")
        int likeCount,
        @Schema(description = "로그인한 사용자가 좋아요를 눌렀는지 여부", example = "true")
        boolean isLiked,
        @Schema(description = "재생 시간 (m:ss)", example = "1:30")
        String playTime
) {

    public static SongDetailResponse of(SongWithDetail songWithDetail, List<Artist> artists, boolean isLiked) {
        Song song = songWithDetail.song();
        SongDetail detail = songWithDetail.detail();

        return new SongDetailResponse(
                song.getId(),
                song.getTitle(),
                artists.stream().map(ArtistInfo::new).toList(),
                new AlbumInfo(song.getAlbum()),
                detail.getLikeCount(),
                isLiked,
                formatSeconds(song.getPlayTime())
        );
    }

    private static String formatSeconds(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;

        return String.format("%d:%02d", minutes, seconds);

    }

    record ArtistInfo(
            @Schema(description = "아티스트 ID", example = "1")
            Long artistId,
            @Schema(description = "아티스트 이름", example = "Hearts2Hearts (하츠투하츠)")
            String name
    ) {

        public ArtistInfo(Artist artist) {
            this(artist.getId(), artist.getName());
        }
    }

    record AlbumInfo(
            @Schema(description = "앨범 ID", example = "1")
            Long albumId,
            @Schema(description = "앨범 제목", example = "앨범 이름")
            String title,
            @Schema(description = "앨범 커버 이미지 URL", example = "https://static.melon.com/album_cover.png")
            String imageUrl
    ) {

        public AlbumInfo(Album album) {
            this(album.getId(), album.getTitle(), album.getImageUrl());
        }
    }
}
