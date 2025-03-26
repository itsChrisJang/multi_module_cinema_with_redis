package project.redis.movie.entity;

import jakarta.persistence.*;
import lombok.*;
import project.redis.common.entity.BaseEntity;
import project.redis.common.mapper.BaseMapper;
import project.redis.domain.movie.Genre;
import project.redis.domain.movie.Movie;
import project.redis.domain.movie.Rating;
import project.redis.domain.schedule.Schedule;
import project.redis.schedule.entity.ScheduleEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "movie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;

    @Column(name = "release_de")
    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "film_rating")
    private Rating filmRating;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @Column(name = "running_time")
    private Integer runningTime;

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    @OrderBy("startTime ASC")
    private List<ScheduleEntity> schedules = new ArrayList<>();

    public Movie toDomain(
            MovieEntity movieEntity,
            BaseMapper<Schedule, ScheduleEntity> scheduleMapper
    ) {
        return new Movie(
                movieEntity.getId(),
                movieEntity.getTitle(),
                movieEntity.getGenre(),
                movieEntity.getReleaseDate(),
                movieEntity.getFilmRating(),
                movieEntity.getThumbnailUrl(),
                movieEntity.getRunningTime(),
                movieEntity.getSchedules().stream()
                        .map(scheduleMapper::toDomain)
                        .collect(Collectors.toList())
        );
    }
}
