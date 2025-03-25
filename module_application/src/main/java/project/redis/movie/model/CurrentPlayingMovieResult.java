package project.redis.movie.model;

import lombok.*;
import project.redis.domain.movie.MovieGenre;
import project.redis.domain.movie.MovieRate;
import project.redis.domain.schedule.Schedule;
import project.redis.movie.dto.CurrentPlayingMovieProjection;
import project.redis.movie.dto.ScheduleProjection;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class CurrentPlayingMovieResult {

    private Long id;
    private String title;
    private MovieGenre genre;
    private LocalDate releaseDate;
    private MovieRate rating;
    private String thumbnailUrl;
    private Integer runningTime;
    private List<ScheduleProjection> schedules;

    public static CurrentPlayingMovieResult of(
            CurrentPlayingMovieProjection movieProjection
    ) {
        return new CurrentPlayingMovieResult(
                movieProjection.id(),
                movieProjection.title(),
                movieProjection.genre(),
                movieProjection.releaseDate(),
                movieProjection.rating(),
                movieProjection.thumbnailUrl(),
                movieProjection.runningTime(),
                movieProjection.schedules()
        );
    }

}
