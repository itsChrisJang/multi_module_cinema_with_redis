package project.redis.movie.dto;

import project.redis.domain.movie.MovieGenre;
import project.redis.domain.movie.MovieRate;

import java.time.LocalDate;
import java.util.List;

public record CurrentPlayingMovieProjection(
        Long id,
        String title,
        MovieGenre genre,
        LocalDate releaseDate,
        MovieRate rating,
        String thumbnailUrl,
        Integer runningTime,
        List<ScheduleProjection> schedules
) {}
