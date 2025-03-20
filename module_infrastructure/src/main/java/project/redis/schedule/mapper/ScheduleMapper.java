package project.redis.schedule.mapper;

import project.redis.domain.schedule.Schedule;
import project.redis.schedule.entity.ScheduleEntity;

public interface ScheduleMapper {
    Schedule toDomain(ScheduleEntity screenEntity);
}
