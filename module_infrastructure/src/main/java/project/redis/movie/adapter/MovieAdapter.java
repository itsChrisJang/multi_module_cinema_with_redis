package project.redis.movie.adapter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import project.redis.common.mapper.BaseMapper;
import project.redis.domain.movie.Movie;
import project.redis.movie.entity.MovieEntity;
import project.redis.movie.repository.MovieRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class MovieAdapter {

    private final MovieRepository movieRepository;
    private final BaseMapper<Movie, MovieEntity> movieMapper;

    public MovieAdapter(MovieRepository movieRepository, BaseMapper<Movie, MovieEntity> movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public List<Movie> findAllMovies() {
        return  movieRepository.findAll().stream()
                .map(movieMapper::toDomain)
                .toList();
    }

    public List<Movie> findCurrentPlayingMovies() {
        return movieRepository.findNowPlayingMovies(LocalDate.now(), LocalDateTime.now()).stream()
                .map(movieMapper::toDomain)
                .toList();
    }

    public List<Movie> getCurrentPlayingMoviesWithSchedules() {
        return movieRepository.findNowPlayingMoviesWithSchedules(LocalDate.now(), LocalDateTime.now()).stream()
                .map(movieMapper::toDomain)
                .toList();
    }

}
