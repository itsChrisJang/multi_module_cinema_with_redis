package project.redis.movie.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.*;
import project.redis.schedule.dto.ScheduleDto;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CurrentPlayingMovieResponseDto {

    private String movieName;
    private String movieRate;
    private LocalDateTime movieReleaseDate;
    private String movieThumbnailImage;
    private Integer movieRunningTime;
    private String movieGenre;
    private String cinemaName;
    private List<ScheduleDto> screenings;

}
