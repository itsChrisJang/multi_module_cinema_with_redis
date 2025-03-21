package project.redis.movie.model;

import lombok.Builder;
import project.redis.domain.movie.MovieGenre;

@Builder
public record MovieSearchCondition(
        String title,
        MovieGenre genre
) {
    public static MovieSearchCondition fromRequest(
            String title,
            String genre
    ) {
        return MovieSearchCondition.builder()
                .title(title)
                .genre(MovieGenre.fromDescription(genre))
                .build();
    }
}
