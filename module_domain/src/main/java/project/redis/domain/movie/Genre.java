package project.redis.domain.movie;

import lombok.Getter;

@Getter
public enum Genre {
    ACTION("액션"),
    COMEDY("코미디"),
    DRAMA("드라마"),
    FANTASY("판타지"),
    HORROR("공포"),
    MYSTERY("미스터리"),
    ROMANCE("로맨스"),
    SCI_FI("SF"),
    THRILLER("스릴러"),
    ANIMATION("애니메이션");

    private final String description;

    Genre(String description) {
        this.description = description;
    }

    public static Genre from(String name) {
        for (Genre genre : Genre.values()) {
            if (genre.name().equalsIgnoreCase(name)) {
                return genre;
            }
        }
        return null;
    }

}
