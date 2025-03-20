package project.redis.seat.mapper;

import project.redis.domain.seat.Seat;
import project.redis.seat.entity.SeatEntity;

public interface SeatMapper {
    Seat toDomain(SeatEntity seatEntity);
}
