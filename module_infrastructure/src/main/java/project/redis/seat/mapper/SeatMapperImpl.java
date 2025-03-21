package project.redis.seat.mapper;

import org.springframework.stereotype.Component;
import project.redis.common.mapper.BaseMapper;
import project.redis.domain.seat.Seat;
import project.redis.seat.entity.SeatEntity;

@Component
public class SeatMapperImpl implements BaseMapper<Seat, SeatEntity> {

    @Override
    public Seat toDomain(SeatEntity seatEntity) {
        return Seat.of(seatEntity.getScreen().getId(), seatEntity.getStatus(), seatEntity.getRow(), seatEntity.getColumn());
    }

}
