package project.redis.movie.adapter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import project.redis.common.mapper.BaseMapper;
import project.redis.domain.movie.Movie;
import project.redis.domain.movie.Genre;
import project.redis.movie.dto.CurrentPlayingMovieProjection;
import project.redis.movie.entity.MovieEntity;
import project.redis.movie.repository.MovieQueryRepository;
import project.redis.movie.repository.MovieRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class MovieAdapter {

    private final MovieRepository movieRepository;
    private final MovieQueryRepository movieQueryRepository;
    private final BaseMapper<Movie, MovieEntity> movieMapper;

    public MovieAdapter(MovieRepository movieRepository, MovieQueryRepository movieQueryRepository, BaseMapper<Movie, MovieEntity> movieMapper) {
        this.movieRepository = movieRepository;
        this.movieQueryRepository = movieQueryRepository;
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

    public List<CurrentPlayingMovieProjection> getCurrentPlayingMoviesWithSchedules(
            String title,
            Genre genre
    ) {
        return movieQueryRepository.findCurrentPlayingMoviesWithSchedules(title, genre);
    }

}
