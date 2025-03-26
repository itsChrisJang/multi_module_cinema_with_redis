package project.redis.movie.dto;

import project.redis.domain.movie.Genre;
import project.redis.domain.movie.Rating;

import java.time.LocalDate;
import java.util.List;

public record CurrentPlayingMovieProjection(
        Long id,
        String title,
        Genre genre,
        LocalDate releaseDate,
        Rating rating,
        String thumbnailUrl,
        Integer runningTime,
        List<ScheduleProjection> schedules
) {}
