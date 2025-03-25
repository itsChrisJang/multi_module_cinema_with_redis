package project.redis.movie.dto;

import java.time.LocalDateTime;

public record ScheduleProjection(
        LocalDateTime startTime,
        LocalDateTime endTime,
        String screenName
) {}

