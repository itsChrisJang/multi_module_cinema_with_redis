package project.redis.screen;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import project.redis.movie.MovieGenre;
import project.redis.movie.MovieRate;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Screen {

    private String screenName;

    public static Screen of(String movieName) {
        return new Screen(movieName);
    }

}
