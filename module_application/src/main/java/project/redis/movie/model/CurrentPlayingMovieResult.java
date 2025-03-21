package project.redis.movie.model;

import java.time.LocalDate;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.redis.domain.movie.Movie;
import project.redis.domain.movie.MovieGenre;
import project.redis.domain.movie.MovieRate;
import project.redis.domain.schedule.Schedule;

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
    private List<Schedule> schedules;

    public static CurrentPlayingMovieResult of(
            Movie movie
    ) {
        return new CurrentPlayingMovieResult(
                movie.getId(),
                movie.getTitle(),
                movie.getGenre(),
                movie.getReleaseDate(),
                movie.getRate(),
                movie.getThumbnailUrl(),
                movie.getRunningTime(),
                movie.getSchedules()
        );
    }

}
