package project.redis.movie.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import project.redis.movie.adapter.MovieAdapter;
import project.redis.movie.dto.CurrentPlayingMovieProjection;
import project.redis.movie.dto.CurrentPlayingMovieResult;
import project.redis.movie.dto.MovieSearchCondition;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {

    private final MovieAdapter movieAdapter;

    public List<CurrentPlayingMovieResult> getCurrentPlayingMovies(
            MovieSearchCondition movieSearchCondition
    ) {
        // 제목과 장르로 필터링
        List<CurrentPlayingMovieProjection> currentPlayingMoviesWithSchedules = movieAdapter.getCurrentPlayingMoviesWithSchedules(movieSearchCondition.title(), movieSearchCondition.genre());

        // 개봉일 순서로 정렬

        // Schedule 시작 시간 정렬
        return currentPlayingMoviesWithSchedules.stream()
                .map(CurrentPlayingMovieResult::of)
                .collect(Collectors.toList());
    }

}
