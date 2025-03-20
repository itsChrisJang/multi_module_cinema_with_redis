package project.redis.screen.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.redis.domain.screen.Screen;
import project.redis.screen.entity.ScreenEntity;

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
