package project.redis.movie.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.redis.movie.Movie;
import project.redis.movie.adapter.MovieAdapter;
import project.redis.movie.dto.CurrentPlayingMovieDto;
import project.redis.schedule.Schedule;
import project.redis.schedule.adapter.ScheduleAdapter;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieAdapter movieAdapter;
    private final ScheduleAdapter screeningAdapter;

    public List<CurrentPlayingMovieDto> getCurrentPlayingMovies() {
        return movieAdapter.getCurrentPlayingMoviesWithSchedules().stream()
                .map(CurrentPlayingMovieDto::of)
                .collect(Collectors.toList());
    }

    private List<Movie> filterAndSortReleasedMovies(
            List<Movie> movies
    ) {
        LocalDate today = LocalDate.now();

        return movies.stream()
                .filter(movie -> movie.isReleasedBefore(today))
                .sorted(Movie::compareReleaseDate)
                .collect(Collectors.toList());
    }

    public List<CurrentPlayingMovieDto> makeNowPlayingMoviesInfo(
            List<Movie> movies
    ) {
        List<CurrentPlayingMovieDto> currentPlayingMovieDtos = new ArrayList<>();
//        for (Movie movie : movies) {
//            // 영화 이름이 같을 수도 있지 않나...?
//            movieAdapter.findMovies()
//            List<Schedule> movieAllSchedule = screeningAdapter.get(movie.getMovieName());
//
//            Map<String, List<Schedule>> cinemaNameScreening = movieAllSchedule.stream()
//                    .collect(Collectors.groupingBy(Schedule::getCinemaName));
//
//            for (Map.Entry<String, List<Schedule>> entry : cinemaNameScreening.entrySet()) {
//                String cinemaName = entry.getKey();
//                List<Schedule> schedules = entry.getValue();
//                CurrentPlayingMovieDto currentPlayingMovieDto = makeNowPlayMovieDto(movie, cinemaName, schedules);
//                currentPlayingMovieDtos.add(currentPlayingMovieDto);
//            }
//        }
        return currentPlayingMovieDtos;
    }
}
