package project.redis.seat.mapper;

import project.redis.seat.Seat;
import project.redis.seat.entity.SeatEntity;

public interface SeatMapper {
    Seat toDomain(SeatEntity seatEntity);
}
