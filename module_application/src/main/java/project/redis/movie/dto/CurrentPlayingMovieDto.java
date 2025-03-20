package project.redis.movie.dto;

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
public class CurrentPlayingMovieDto {

    private String title;
    private MovieGenre genre;
    private LocalDate releaseDate;
    private MovieRate rating;
    private String thumbnailUrl;
    private Integer runningTime;
    private List<Schedule> schedules;

    public static CurrentPlayingMovieDto of(
            Movie movie
    ) {
        return new CurrentPlayingMovieDto(
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
