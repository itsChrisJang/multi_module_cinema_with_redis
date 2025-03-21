package project.redis.domain.screen;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Screen {

    private Long id;
    private String name;

    public static Screen of(Long id, String movieName) {
        return new Screen(id, movieName);
    }

}
