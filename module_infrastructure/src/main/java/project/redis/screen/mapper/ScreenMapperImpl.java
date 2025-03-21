package project.redis.screen.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.redis.common.mapper.BaseMapper;
import project.redis.domain.screen.Screen;
import project.redis.screen.entity.ScreenEntity;

@Component
@RequiredArgsConstructor
public class ScreenMapperImpl implements BaseMapper<Screen, ScreenEntity> {

    @Override
    public Screen toDomain(ScreenEntity screenEntity) {
        //List<Seat> seats = convertSeatEntitiesToSeats(cinemaEntity.getSeats());
        //CinemaSeats cinemaSeats = CinemaSeats.create();
        return Screen.of(screenEntity.getId(), screenEntity.getName());
    }

}
