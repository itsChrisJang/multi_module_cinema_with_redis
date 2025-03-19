package project.redis.movie.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.redis.schedule.dto.ScreeningDto;

@Getter
@Setter
@NoArgsConstructor
public class NowPlayingMovieResponseDto {
    private String movieName;
    private String movieRate;
    private LocalDateTime movieReleaseDate;
    private String movieThumbnailImage;
    private Integer movieRunningTime;
    private String movieGenre;
    private String cinemaName;
    private List<ScreeningDto> screenings;
}
