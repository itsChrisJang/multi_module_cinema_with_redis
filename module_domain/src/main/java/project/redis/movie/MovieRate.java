package project.redis.movie;

import lombok.Getter;

@Getter
public enum MovieRate {
    ALL("전체관람가"),
    TWELVE("12세 이상 관람가"),
    FIFTEEN("15세 이상 관람가"),
    NINETEEN("19세 이상 관림가"),
    RESTRICT("제한상영가");

    private final String description;

    MovieRate(String description) {
        this.description = description;
    }
}
