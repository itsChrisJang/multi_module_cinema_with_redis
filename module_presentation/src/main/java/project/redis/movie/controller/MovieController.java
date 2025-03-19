package project.redis.movie.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.redis.movie.dto.CurrentPlayingMovieDto;
import project.redis.movie.service.MovieService;

@RestController
@RequestMapping("/rest/api/v1/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/now-playing")
    public ResponseEntity<?> getNowPlayingMovies() {
        List<CurrentPlayingMovieDto> currentPlayingMovieDtos = movieService.getCurrentPlayingMovies();
        return ResponseEntity.ok(currentPlayingMovieDtos);
    }
}
