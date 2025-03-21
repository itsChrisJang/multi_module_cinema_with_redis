package project.redis.domain.movie;

import java.time.LocalDate;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import project.redis.domain.schedule.Schedule;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Movie {

    private Long id;
    private String title;
    private MovieGenre genre;
    private LocalDate releaseDate;
    private MovieRate rate;
    private String thumbnailUrl;
    private Integer runningTime;
    private List<Schedule> schedules;

    public static Movie of(
            Long id,
            String title,
            MovieGenre genre,
            LocalDate releaseDate,
            MovieRate rating,
            String thumbnailUrl,
            Integer runningTime,
            List<Schedule> schedules
    ) {
        return new Movie(id, title, genre, releaseDate, rating, thumbnailUrl, runningTime, schedules);
    }

    public boolean isReleasedBefore(LocalDate date) {
        return releaseDate.isBefore(date);
    }

    public int compareReleaseDate(Movie movieToCompare) {
        return movieToCompare.releaseDate.compareTo(this.releaseDate);
    }

}
