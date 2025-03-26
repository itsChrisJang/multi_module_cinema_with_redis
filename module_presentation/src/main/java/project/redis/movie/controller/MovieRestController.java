package project.redis.movie.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import project.redis.movie.dto.CurrentPlayingMovieResult;
import project.redis.movie.dto.MovieSearchCondition;
import project.redis.movie.dto.CurrentPlayingMovieSearchingRequest;
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
            @Valid @ModelAttribute CurrentPlayingMovieSearchingRequest currentPlayingMovieSearchingRequest
    ) {
        return movieService.getCurrentPlayingMovies(
                MovieSearchCondition.fromRequest(
                        currentPlayingMovieSearchingRequest.getTitle(),
                        currentPlayingMovieSearchingRequest.getGenre()
                )
        );
    }
}
