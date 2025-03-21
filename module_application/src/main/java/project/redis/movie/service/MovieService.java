package project.redis.movie.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.redis.domain.movie.Movie;
import project.redis.movie.adapter.MovieAdapter;
import project.redis.movie.model.CurrentPlayingMovieResult;
import project.redis.movie.model.MovieSearchCondition;
import project.redis.schedule.adapter.ScheduleAdapter;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {

    private final MovieAdapter movieAdapter;
    private final ScheduleAdapter screeningAdapter;

    public List<CurrentPlayingMovieResult> getCurrentPlayingMovies(
            MovieSearchCondition movieSearchCondition
    ) {
        List<Movie> currentPlayingMoviesWithSchedules = movieAdapter.getCurrentPlayingMoviesWithSchedules();
        return currentPlayingMoviesWithSchedules.stream()
                .map(CurrentPlayingMovieResult::of)
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

    public List<CurrentPlayingMovieResult> makeNowPlayingMoviesInfo(
            List<Movie> movies
    ) {
        List<CurrentPlayingMovieResult> currentPlayingMovieResults = new ArrayList<>();
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
        return currentPlayingMovieResults;
    }
}
