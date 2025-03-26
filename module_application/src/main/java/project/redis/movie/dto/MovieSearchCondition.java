package project.redis.movie.dto;

import lombok.Builder;
import project.redis.domain.movie.Genre;

@Builder
public record MovieSearchCondition(
        String title,
        Genre genre
) {
    public static MovieSearchCondition fromRequest(
            String title,
            String genre
    ) {
        return MovieSearchCondition.builder()
                .title(title)
                .genre(Genre.from(genre))
                .build();
    }
}
