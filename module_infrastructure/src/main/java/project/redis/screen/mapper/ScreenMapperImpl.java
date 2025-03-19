package project.redis.screen.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.redis.cinema.Cinema;
import project.redis.screen.Screen;
import project.redis.screen.entity.ScreenEntity;
import project.redis.seat.Seat;
import project.redis.seat.entity.SeatEntity;
import project.redis.seat.mapper.SeatMapper;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ScreenMapperImpl implements ScreenMapper {

    @Override
    public Screen toDomain(ScreenEntity screenEntity) {
        //List<Seat> seats = convertSeatEntitiesToSeats(cinemaEntity.getSeats());
        //CinemaSeats cinemaSeats = CinemaSeats.create();
        return Screen.of(screenEntity.getName());
    }

}
