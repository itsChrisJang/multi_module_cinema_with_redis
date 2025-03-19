package com.hanghae99.skillup.movie.domain.repository;

import com.hanghae99.skillup.movie.domain.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MovieRepository extends JpaRepository<Movie, Long> {}
