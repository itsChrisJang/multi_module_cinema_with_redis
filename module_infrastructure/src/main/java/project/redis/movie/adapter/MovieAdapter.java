package project.redis.movie.adapter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;
import project.redis.movie.Movie;
import project.redis.movie.mapper.MovieMapper;
import project.redis.movie.repository.MovieRepository;

@Component
public class MovieAdapter {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public MovieAdapter(MovieRepository movieRepository, MovieMapper movieMapper) {
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
