package project.redis.domain.schedule;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import project.redis.domain.movie.Movie;
import project.redis.domain.screen.Screen;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Schedule {

    private Movie movie;
    private Screen screen;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public static Schedule of(Movie movie, Screen screen, LocalDateTime startTime, LocalDateTime endTime) {
        return new Schedule(movie, screen, startTime, endTime);
    }

    public String getScreenName() {
        return this.screen.getName();
    }
}
