package project.redis.domain.movie;

import lombok.Getter;
import lombok.ToString;
import project.redis.domain.schedule.Schedule;

import java.time.LocalDate;
import java.util.List;

@Getter
@ToString
public class Movie {

    private Long id;
    private String title;
    private Genre genre;
    private LocalDate releaseDate;
    private Rating rate;
    private String thumbnailUrl;
    private Integer runningTime;
    private List<Schedule> schedules;

    public Movie(Long id, String title, Genre genre, LocalDate releaseDate, Rating rate, String thumbnailUrl, Integer runningTime, List<Schedule> schedules) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.rate = rate;
        this.thumbnailUrl = thumbnailUrl;
        this.runningTime = runningTime;
        this.schedules = schedules;
    }

    public boolean isReleasedBefore(LocalDate date) {
        return releaseDate.isBefore(date);
    }

    public int compareReleaseDate(Movie movieToCompare) {
        return movieToCompare.releaseDate.compareTo(this.releaseDate);
    }

}
