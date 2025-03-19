package project.redis.movie;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import project.redis.schedule.Schedule;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Movie {

    private String title;
    private MovieGenre genre;
    private LocalDate releaseDate;
    private MovieRate rate;
    private String thumbnailUrl;
    private Integer runningTime;
    private List<Schedule> schedules;

    public static Movie of(
            String title,
            MovieGenre genre,
            LocalDate releaseDate,
            MovieRate rating,
            String thumbnailUrl,
            Integer runningTime,
            List<Schedule> schedules
    ) {
        return new Movie(title, genre, releaseDate, rating, thumbnailUrl, runningTime, schedules);
    }

    public boolean isReleasedBefore(LocalDate date) {
        return releaseDate.isBefore(date);
    }

    public int compareReleaseDate(Movie movieToCompare) {
        return movieToCompare.releaseDate.compareTo(this.releaseDate);
    }

}
