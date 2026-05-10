package org.sopt.collaboration.melon.domain.artist.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.YearMonth;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "artist_details")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArtistDetail {

    @Id
    @Column(name = "artist_id")
    private Long artistId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", insertable = false, updatable = false)
    private Artist artist;

    @Column(name = "comment_count", nullable = false)
    private int commentCount;

    @Column(name = "fan_count", nullable = false)
    private int fanCount;

    @Column(name = "active_degree", nullable = false)
    private int activeDegree;

    @Column(name = "credit")
    private String credit;

    @Column(name = "debut_year_month", nullable = false)
    private YearMonth debutYearMonth;

    @Column(name = "country")
    private String country;

    @Column(name = "agency")
    private String agency;

    @Column(name = "award_history", columnDefinition = "TEXT")
    private String awardHistory;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
}
