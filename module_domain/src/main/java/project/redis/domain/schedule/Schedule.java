package project.redis.domain.schedule;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import project.redis.domain.movie.Movie;
import project.redis.domain.screen.Screen;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Schedule {

    private Screen screen;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public static Schedule of(Screen screen, LocalDateTime startTime, LocalDateTime endTime) {
        return new Schedule(screen, startTime, endTime);
    }

}
