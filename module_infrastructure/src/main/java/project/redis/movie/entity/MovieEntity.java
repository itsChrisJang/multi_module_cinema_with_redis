package project.redis.movie.entity;

import jakarta.persistence.*;
import lombok.*;
import project.redis.common.entity.BaseEntity;
import project.redis.movie.MovieGenre;
import project.redis.movie.MovieRate;
import project.redis.schedule.entity.ScheduleEntity;
import project.redis.screen.entity.ScreenEntity;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "MOVIE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENRE")
    private MovieGenre genre;

    @Column(name = "RELEASE_DATE")
    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "FILM_RATING")
    private MovieRate filmRating;

    @Column(name = "THUMBNAIL_URL")
    private String thumbnailUrl;

    @Column(name = "RUNNING_TIME")
    private Integer runningTime;

    @OneToMany(mappedBy = "movie")
    private List<ScheduleEntity> schedules;

}
