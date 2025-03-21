package project.redis.movie.entity;

import jakarta.persistence.*;
import lombok.*;
import project.redis.common.entity.BaseEntity;
import project.redis.domain.movie.MovieGenre;
import project.redis.domain.movie.MovieRate;
import project.redis.schedule.entity.ScheduleEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private MovieGenre genre;

    @Column(name = "release_de")
    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "film_rating")
    private MovieRate filmRating;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @Column(name = "running_time")
    private Integer runningTime;

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    @OrderBy("startTime ASC")
    private List<ScheduleEntity> schedules = new ArrayList<>();

}
