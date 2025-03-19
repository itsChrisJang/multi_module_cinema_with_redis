package project.redis.movie;

import lombok.Getter;

@Getter
public enum MovieGenre {
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

    MovieGenre(String movieGenreDescription) {
        this.description = movieGenreDescription;
    }
}
