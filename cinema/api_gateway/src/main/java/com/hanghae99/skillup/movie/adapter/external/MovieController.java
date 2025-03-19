package com.hanghae99.skillup.movie.adapter.external;

import com.hanghae99.skillup.movie.domain.repository.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/v1/movie")
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/available")
    public ResponseEntity<List<Void>> getAvailableSchedules() {
        movieRepository.findAll();
        List<Void> availableSchedules = new ArrayList<>();
        return ResponseEntity.ok(availableSchedules);
    }

}
