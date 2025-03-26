package project.redis.movie.dto;

import lombok.*;
import project.redis.domain.movie.Genre;
import project.redis.domain.movie.Rating;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class CurrentPlayingMovieResult {

    private Long id;
    private String title;
    private Genre genre;
    private LocalDate releaseDate;
    private Rating rating;
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
