package project.redis.movie.mapper;

import project.redis.domain.movie.Movie;
import project.redis.movie.entity.MovieEntity;

public interface MovieMapper {
    Movie toDomain(MovieEntity movieEntity);
}
