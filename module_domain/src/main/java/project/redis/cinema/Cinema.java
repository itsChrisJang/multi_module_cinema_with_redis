package project.redis.cinema;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Cinema {

    @Getter
    private String cinemaName;
    private CinemaSeats cinemaSeats;

    public static Cinema of(String cinemaName) {
        return new Cinema(cinemaName, CinemaSeats.create());
    }
}
