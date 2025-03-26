package project.redis.movie.dto;

import project.redis.domain.movie.Genre;
import project.redis.domain.movie.Rating;

import java.time.LocalDate;
import java.time.LocalDateTime;

// 평탄한 DTO
public record FlatMovieScheduleRow(
        Long movieId,
        String title,
        Genre genre,
        LocalDate releaseDate,
        Rating rating,
        String thumbnailUrl,
        Integer runningTime,
        LocalDateTime startTime,
        LocalDateTime endTime,
        String screenName
) {}

