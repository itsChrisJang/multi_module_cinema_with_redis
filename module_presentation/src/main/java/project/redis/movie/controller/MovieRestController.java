package project.redis.movie.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.logging.LogLevel;
import org.springframework.web.bind.annotation.*;
import project.redis.movie.model.CurrentPlayingMovieResult;
import project.redis.movie.model.MovieSearchCondition;
import project.redis.movie.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/rest/api/v1/movie")
public class MovieRestController {

    private final MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/now-playing")
    public List<CurrentPlayingMovieResult> getNowPlayingMovies(
            @Valid @ModelAttribute MovieSearchRequest movieSearchRequest
    ) {
        return movieService.getCurrentPlayingMovies(
                MovieSearchCondition.fromRequest(
                        movieSearchRequest.getTitle(),
                        movieSearchRequest.getGenre()
                )
        );
    }
}
