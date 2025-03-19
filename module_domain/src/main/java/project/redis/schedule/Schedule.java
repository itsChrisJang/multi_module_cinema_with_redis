package project.redis.schedule;

import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import project.redis.cinema.Cinema;
import project.redis.movie.Movie;
import project.redis.screen.Screen;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Schedule {

    private Movie movie;
    private Screen screen;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public static Schedule of(Movie movie, Screen screen, LocalDateTime startTime, LocalDateTime endTime) {
        return new Schedule(movie, screen, startTime, endTime);
    }

    public String getCinemaName() {
        return this.cinema.getCinemaName();
    }
}
