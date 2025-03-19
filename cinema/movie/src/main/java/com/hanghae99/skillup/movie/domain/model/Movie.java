package com.hanghae99.skillup.movie.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "MOVIE")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 300, nullable = false)
    private String name;

    @Column(name = "GENRE", length = 10, nullable = false)
    private String genre;

    @Column(name = "RELEASE_DE")
    private LocalDate releaseDate;

    @Column(name = "FILM_RATING", length = 10)
    private String filmRating;

    @Column(name = "THUMBNAIL_URL", length = 500)
    private String thumbnailUrl;

    @Column(name = "RUNNING_TIME")
    private Integer runningTime;

    @Column(name = "REG_DT", nullable = false)
    private LocalDateTime regDt;

    @Column(name = "REG_ID", length = 30, nullable = false)
    private String regId;

    @Column(name = "UPD_DT")
    private LocalDateTime updDt;

    @Column(name = "UPD_ID", length = 30)
    private String updId;
}
