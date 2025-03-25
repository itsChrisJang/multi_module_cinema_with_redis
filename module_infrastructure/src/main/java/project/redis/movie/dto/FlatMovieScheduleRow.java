package project.redis.movie.dto;

import project.redis.domain.movie.MovieGenre;
import project.redis.domain.movie.MovieRate;

import java.time.LocalDate;
import java.time.LocalDateTime;

// 평탄한 DTO
public record FlatMovieScheduleRow(
        Long movieId,
        String title,
        MovieGenre genre,
        LocalDate releaseDate,
        MovieRate rating,
        String thumbnailUrl,
        Integer runningTime,
        LocalDateTime startTime,
        LocalDateTime endTime,
        String screenName
) {}

